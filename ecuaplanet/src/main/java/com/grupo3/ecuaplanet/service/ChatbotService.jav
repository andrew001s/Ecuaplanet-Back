package com.grupo3.ecuaplanet.service;

import com.grupo3.ecuaplanet.model.Cajas;
import com.grupo3.ecuaplanet.model.Clientes;
import com.grupo3.ecuaplanet.model.IngresoMallas;
import com.grupo3.ecuaplanet.model.Pedidos;
import com.grupo3.ecuaplanet.model.ProduccionBonches;
import com.grupo3.ecuaplanet.model.ProductosBonches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatbotService {

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private CajasService cajasService;

    @Autowired
    private IngresoMallasService ingresoMallasService;

    @Autowired
    private PedidosService pedidosService;

    @Autowired
    private ProduccionBonchesService produccionBonchesService;

    @Autowired
    private ProductosBonchesService productosBonchesService;

    public String procesarMensaje(String mensajeUsuario) {
        try {
            // 1. Enviar el mensaje a GeminiService para obtener la intención y las entidades
            String respuestaGemini = geminiService.getResponse(mensajeUsuario).block(); // Usar .block() para obtener la respuesta de forma síncrona

            // 2. Interpretar la intención y las entidades
            String intencion = extraerIntencion(respuestaGemini);
            String entidades = extraerEntidades(respuestaGemini);

            // 3. Ejecutar la consulta a la base de datos según la intención
            String resultadoConsulta = ejecutarConsulta(intencion, entidades);

            // 4. Formatear la respuesta (si es necesario) y devolverla
            return resultadoConsulta;

        } catch (Exception e) {
            // Manejar la excepción
            System.err.println("Error en ChatbotService: " + e.getMessage());
            return "Error al procesar la solicitud.";
        }
    }

    // Método para extraer la intención de la respuesta de Gemini (ejemplo básico)
    private String extraerIntencion(String respuestaTexto) {
        if (respuestaTexto.toLowerCase().contains("cliente")) {
            return "consultar_cliente";
        } else if (respuestaTexto.toLowerCase().contains("caja")) {
            return "consultar_caja";
        } else if (respuestaTexto.toLowerCase().contains("malla")) {
            return "consultar_malla";
        } else if (respuestaTexto.toLowerCase().contains("pedido")) {
            return "consultar_pedido";
        } else if (respuestaTexto.toLowerCase().contains("produccion")) {
            return "consultar_produccion_bonche";
        } else if (respuestaTexto.toLowerCase().contains("producto")) {
            return "consultar_producto_bonche";
        }
        // Agrega más casos según las intenciones que esperas
        return "desconocido";
    }

 // Método para extraer entidades de la respuesta de Gemini (ejemplo básico)
    private String extraerEntidades(String respuestaTexto) {
        try {
            JsonObject jsonResponse = gson.fromJson(respuestaTexto, JsonObject.class);

            if (jsonResponse.has("candidates")) {
                String respuestaCompleta = jsonResponse.getAsJsonArray("candidates")
                        .get(0).getAsJsonObject()
                        .getAsJsonObject("content")
                        .getAsJsonArray("parts")
                        .get(0).getAsJsonObject()
                        .get("text").getAsString();

                // Supongamos que la respuesta de Gemini para una consulta de cliente es algo como:
                // "El cliente que buscas es Juan Perez." o "Cliente: Juan Perez"
                // Vamos a extraer el nombre usando una lógica simple (que hay que mejorar)

                // 1. Dividir la respuesta en palabras
                String[] palabras = respuestaCompleta.split("\\s+"); // Dividir por espacios en blanco

                // 2. Buscar palabras clave o patrones (Ajustar la logica segun el formato que devuelva la API de Gemini)
                for (int i = 0; i < palabras.length; i++) {
                    // Ejemplo: Si encuentras "Cliente:" asumes que la siguiente palabra es el nombre
                    if (palabras[i].equalsIgnoreCase("Cliente:") && i + 1 < palabras.length) {
                        return palabras[i + 1];
                    }
                
                    if (palabras[i].equalsIgnoreCase("Cliente") && i + 1 < palabras.length) {
                        return palabras[i + 1];
                    }

                    if (palabras[i].equalsIgnoreCase("es") && i + 1 < palabras.length) {
                        return palabras[i + 1];
                    }
                }
                
                return respuestaCompleta; // Si no se encuentra un patrón específico, devolver la respuesta completa
            } else {
                System.err.println("La respuesta de Gemini no tiene el campo 'candidates'.");
                return "";
            }
        } catch (Exception e) {
            System.err.println("Error al extraer entidades: " + e.getMessage());
            return "";
        }
    }

    // Método para ejecutar la consulta a la base de datos
    private String ejecutarConsulta(String intencion, String entidades) {
        switch (intencion) {
            case "consultar_cliente":
                // Ejemplo: Consultar cliente por nombre
                Optional<Clientes> clienteOptional = clientesService.getClienteByNombre(entidades);
                if (clienteOptional.isPresent()) {
                    Clientes cliente = clienteOptional.get();
                    return cliente.toString(); // o formatea la respuesta como necesites
                } else {
                    return "Cliente no encontrado.";
                }
            case "consultar_caja":
                // Ejemplo: Obtener caja por ID
                try {
                    Long cajaId = Long.parseLong(entidades);
                    Optional<Cajas> cajaOptional = cajasService.getCajaById(cajaId);
                    if (cajaOptional.isPresent()) {
                        Cajas caja = cajaOptional.get();
                        return caja.toString();
                    } else {
                        return "Caja no encontrada.";
                    }
                } catch (NumberFormatException e) {
                    return "ID de caja no válido.";
                }
            case "consultar_malla":
                // Ejemplo: Obtener mallas por ID de variedad
                try {
                    Long variedadId = Long.parseLong(entidades);
                    List<IngresoMallas> mallas = ingresoMallasService.getIngresosMallasByVariedadId(variedadId);
                    if (!mallas.isEmpty()) {
                        return mallas.toString();
                    } else {
                        return "No se encontraron mallas para la variedad especificada.";
                    }
                } catch (NumberFormatException e) {
                    return "ID de variedad no válido.";
                }
            case "consultar_pedido":
                // Ejemplo: Obtener pedido por ID
                try {
                    Long pedidoId = Long.parseLong(entidades);
                    Optional<Pedidos> pedidoOptional = pedidosService.getPedidoById(pedidoId);
                    if (pedidoOptional.isPresent()) {
                        Pedidos pedido = pedidoOptional.get();
                        return pedido.toString();
                    } else {
                        return "Pedido no encontrado.";
                    }
                } catch (NumberFormatException e) {
                    return "ID de pedido no válido.";
                }
            case "consultar_produccion_bonche":
                // Ejemplo: Obtener producción de bonche por ID de producto
                try {
                    Long productoId = Long.parseLong(entidades);
                    List<ProduccionBonches> producciones = produccionBonchesService.getProduccionBonchesByProductoId(productoId);
                    if (!producciones.isEmpty()) {
                        return producciones.toString();
                    } else {
                        return "No se encontró producción de bonches para el producto especificado.";
                    }
                } catch (NumberFormatException e) {
                    return "ID de producto no válido.";
                }

            case "consultar_producto_bonche":
                // Ejemplo: Obtener producto de bonche por ID de variedad
                try {
                    Long variedadId = Long.parseLong(entidades);
                    List<ProductosBonches> productos = productosBonchesService.getProductosBonchesByVariedadId(variedadId);
                    if (!productos.isEmpty()) {
                        return productos.toString();
                    } else {
                        return "No se encontraron productos de bonche para la variedad especificada.";
                    }
                } catch (NumberFormatException e) {
                    return "ID de variedad no válido.";
                }

            // Agrega más casos según las intenciones que definas
            default:
                return "Intención no reconocida.";
        }
    }
}