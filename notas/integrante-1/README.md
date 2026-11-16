# Belinda Toaquiza · RPC, gRPC y Java RMI

**EXP-1 · Equipo LMRT · 0:00–2:00.** Este bloque usa la portada y las dos diapositivas de teoría. La transición a la demo empieza en 2:00.

## Guía de estudio

### RPC y el recorrido de una llamada

RPC significa *Remote Procedure Call*. Permite pedir a otro proceso que ejecute una operación y devuelva un resultado. Imagina que escribes **sumar(3, 4)**. El cliente llama a un *stub*, un representante local que prepara la solicitud y serializa los argumentos para enviarlos como bytes. El servidor recibe la solicitud, recupera los argumentos y ejecuta la suma. Luego codifica y envía la respuesta. El cliente la decodifica y obtiene **7**. En el diagrama, la flecha de ida lleva la solicitud y la de vuelta lleva el resultado o un estado de error. [1]

Un **socket** es la interfaz que usa un proceso para comunicarse por red. La **serialización** convierte datos estructurados en bytes. El **protocolo** establece cómo se intercambian e interpretan los mensajes. El **stub** ofrece al programa una interfaz de llamada y delega la comunicación al runtime. [1]

En una **llamada bloqueante**, el hilo que la hace espera una respuesta o un error. Con una **llamada no bloqueante**, el hilo puede seguir trabajando y recibir el resultado después mediante un callback o un futuro, según la biblioteca. Incluso si el código parece una llamada local, un corte de red o el vencimiento del plazo puede dejar al cliente sin respuesta. En una operación que modifica datos, eso deja abierta la posibilidad de que el servidor sí haya completado el trabajo. [1, 2, 4]

### gRPC

gRPC es un framework que implementa el modelo RPC. En su uso habitual, un archivo **.proto** define el servicio, sus métodos y los tipos de los mensajes. A partir de él se genera código para el cliente y el servidor en los lenguajes compatibles. **Protocol Buffers** define y codifica los mensajes por defecto. **HTTP/2** transporta el intercambio y permite multiplexar varios flujos en una conexión. La suma es una llamada **unaria**, con una petición y una respuesta. gRPC también permite flujos de mensajes desde el cliente, el servidor o ambos. La elección de API bloqueante o no bloqueante depende de la biblioteca y del lenguaje. [2, 4, 5]

### Java RMI

RMI significa *Remote Method Invocation*. En Java RMI, el cliente invoca un método de un **objeto remoto** que vive en otra JVM. El contrato es una interfaz Java que extiende **java.rmi.Remote**. El cliente usa un *stub* que representa al objeto. En un ejemplo típico, obtiene ese *stub* por nombre mediante un registro RMI. La llamada estándar es bloqueante y su interfaz contempla **RemoteException**. Los objetos ordinarios serializables se pasan por copia. Al pasar un objeto remoto exportado se transmite una referencia remota representada por un *stub*. La implementación estándar de Java emplea **JRMP sobre TCP**. El caso de Darbord y colegas muestra cómo se manejaba la serialización binaria al migrar aplicaciones que usaban RMI. [3]

### Qué debes poder explicar sin leer

| Pregunta | Respuesta breve |
|---|---|
| ¿Cómo se relacionan los tres conceptos? | RPC es la abstracción. gRPC la implementa como llamadas a servicios. Java RMI la aplica a métodos de objetos Java remotos. |
| ¿Qué diferencia hay entre Protocol Buffers y HTTP/2? | Protocol Buffers describe y codifica el contenido. HTTP/2 transporta los mensajes. |
| ¿Qué pasa si el servidor calcula y la respuesta se pierde? | El cliente puede recibir un error o agotar su plazo aunque la operación haya terminado. |
| ¿Una llamada unaria también puede ser no bloqueante? | Sí. «Unaria» describe la cantidad de mensajes. «No bloqueante» describe cómo espera el hilo cliente. |
| ¿Es gRPC siempre más rápido? | Depende de la operación, los datos, la carga y el entorno. Los artículos comparan implementaciones bajo condiciones concretas. [2, 4–6] |
| ¿Dónde encaja SGRA? | El intercambio frontend–backend analizado en la presentación usa HTTP con una API REST. La suma permite demostrar una invocación remota antes de pasar a ese caso. |

## Guion de exposición · 2:00

Lee una vez para familiarizarte. En el ensayo, usa el diagrama y las tres columnas como apoyo visual y practica con cronómetro.

**0:00–0:55 · Portada y recorrido RPC**

> Buenos días. Somos el equipo LMRT. Para empezar, imaginen que quiero sumar tres y cuatro, pero la operación se ejecuta en otro proceso. Eso es una llamada a procedimiento remoto, o RPC. En el diagrama, mi programa llama a un representante local, el *stub*. Este convierte los argumentos a bytes y envía la solicitud. El servidor recupera los datos, ejecuta la suma y devuelve siete. Si la llamada es bloqueante, el hilo del cliente espera el resultado o un error. Si es no bloqueante, puede seguir trabajando y atender el resultado después. La red introduce latencia y puede fallar aunque el código parezca una llamada local.

**0:55–2:00 · Comparación y transición**

> RPC es la idea general. gRPC la implementa mediante servicios. En un archivo punto proto se definen los métodos y los mensajes, y a partir de ese contrato se genera código para el cliente y el servidor. Protocol Buffers codifica los datos por defecto y HTTP dos los transporta. Un socket es la interfaz de comunicación con la red. En Java RMI, un programa llama a un método de un objeto que vive en otra máquina virtual de Java. Comparte una interfaz Java y usa un *stub* que representa al objeto remoto. Los datos ordinarios serializables se envían por copia. En una frase, gRPC llama a un servicio y Java RMI llama a un objeto remoto. Ahora veremos una llamada en funcionamiento.

## Fuentes verificadas y lectura recomendada

Las seis publicaciones son de 2022 a 2026 y sus DOI se contrastaron con Crossref. Los PDF compartidos en el repositorio están en **evidencias/capturas-fuentes/PDFs**. Para la fuente [4] se enlaza la descarga de la revista. Esta lista tiene su propia numeración. Las diapositivas citan las cinco primeras y la sexta queda como lectura adicional.

1. K. Seemakhupt et al., “A Cloud-Scale Characterization of Remote Procedure Calls,” en *Proc. 29th ACM SIGOPS Symp. Operating Systems Principles (SOSP)*, pp. 498–514, 2023. Lee la introducción y la sección de contexto para distinguir el código de aplicación de las tareas del sistema de RPC, como preparar los argumentos y gestionar la conexión. [DOI](https://doi.org/10.1145/3600006.3613156) · [SciSpace](https://scispace.com/papers/a-cloud-scale-characterization-of-remote-procedure-calls-1263xkaode) · [PDF local](../../evidencias/capturas-fuentes/PDFs/seemakhupt-et-al-2023-rpc.pdf)
2. Ł. Kamiński, M. Kozłowski, D. Sporysz, K. Wolska, P. Zaniewski y R. Roszczyk, “Comparative Review of Selected Internet Communication Protocols,” *Foundations of Computing and Decision Sciences*, vol. 48, n.º 1, pp. 39–56, 2023. Lee la subsección sobre gRPC y revisa el entorno del benchmark antes de hablar de rendimiento. [DOI](https://doi.org/10.2478/fcds-2023-0003) · [SciSpace](https://scispace.com/papers/comparative-review-of-selected-internet-communication-tes3uthe) · [PDF local](../../evidencias/capturas-fuentes/PDFs/kaminski-et-al-2023-grpc.pdf)
3. G. Darbord, B. Verhaeghe, A. Etien, N. Anquetil, A. Shatnawi, A. Seriai y M. Derras, “Migrating the Communication Protocol of Client–Server Applications,” *IEEE Software*, vol. 40, n.º 4, pp. 11–18, 2023. Busca la sección sobre clases de intercambio de datos para ver un caso real de serialización en RMI. El PDF local es el manuscrito depositado en HAL. [DOI](https://doi.org/10.1109/MS.2023.3263019) · [SciSpace](https://scispace.com/papers/migrating-the-communication-protocol-of-client-server-e2hseq53) · [PDF local](../../evidencias/capturas-fuentes/PDFs/darbord-et-al-2023-java-rmi.pdf)
4. J. Kazanavičius y D. Mažeika, “Evaluation of Microservice Communication While Decomposing Monoliths,” *Computing and Informatics*, vol. 42, n.º 1, pp. 1–36, 2023. Consulta el análisis de tecnologías de comunicación entre procesos. La ficha de la revista y Crossref registran el DOI con guiones bajos. [DOI](https://doi.org/10.31577/cai_2023_1_1) · [SciSpace](https://scispace.com/papers/evaluation-of-microservice-communication-while-decomposing-29hgceib) · [PDF de la revista](https://cai.type.sk/content/2023/1/evaluation-of-microservice-communication-while-decomposing-monoliths/5689.pdf)
5. P. Rożek y M. Dzieńkowski, “A performance comparison of web programming interfaces: GraphQL, gRPC and Thrift,” *Journal of Computer Sciences Institute*, vol. 38, pp. 26–31, 2026. Compara en pp. 28–29 la lectura de varios registros con la de un solo registro. [DOI](https://doi.org/10.35784/jcsi.8383) · [SciSpace](https://scispace.com/papers/a-performance-comparison-of-web-programming-interfaces-ankz2kqeptlq) · [PDF local](../../evidencias/capturas-fuentes/PDFs/rozek-dzienkowski-2026-grpc.pdf)
6. I. Zakutynskyi e I. Rabodzei, “Microservice Communication for IoT-based Systems. Architecture Review and Performance Test,” *Electronics and Control Systems*, 4(74), pp. 73–78, 2022. Úsalo como otro ejemplo de cómo comparar protocolos bajo un escenario definido. [DOI](https://doi.org/10.18372/1990-5548.74.17311) · [SciSpace](https://scispace.com/papers/microservice-communication-for-iot-based-systems-e435ikep) · [PDF local](../../evidencias/capturas-fuentes/PDFs/zakutynskyi-rabodzei-2022-grpc.pdf)
