# Bitácora del equipo LMRT

Aplicaciones Distribuidas (ISR-701) · EXP-1 · Sistema de Gestión de Refuerzos Académicos (SGRA)

Las entradas se reconstruyeron a partir del historial de Git, con fechas de Ecuador continental. La autoría identifica la cuenta que figura en cada commit. El equipo debe completar quiénes participaron en cada sesión y cuánto tiempo dedicaron.

## Plantilla de entrada

### AAAA-MM-DD

- **Commit** — hash corto y descripción.
- **Qué hice** — tarea realizada.
- **Problema encontrado** — dificultad observada o aspecto pendiente.
- **Cómo lo resolví** — cambio aplicado y forma de comprobarlo.
- **Tiempo dedicado** — X h Y min.

## Registro de trabajo

### 2026-11-14 · `e3bf111`

- **Autoría en Git** — `ereinosov`.
- **Qué hice** — Inicialicé el repositorio y agregué el README con los datos del equipo.
- **Problema encontrado** — No se registró un bloqueo técnico. Faltaba organizar los archivos de la exposición.
- **Cómo lo resolví** — Creé las carpetas para diapositivas, notas, diagrama y evidencias, con archivos `.gitkeep` para conservar la estructura inicial.
- **Tiempo dedicado** — 10 min.

### 2026-11-15 · `c35c5f7`

- **Autoría en Git** — Belinda Toaquiza (`BelindaTZ`).
- **Qué hice** — Preparé la plantilla Beamer con los turnos, el diagrama inicial de SGRA y campos para desarrollar cada sección.
- **Problema encontrado** — Había que ajustar el guion a cuatro bloques de tres minutos y mantener la bibliografía en la carpeta de fuentes.
- **Cómo lo resolví** — Organicé las diapositivas en cuatro turnos continuos, actualicé la ruta de `referencias.bib` y verifiqué que Biber encontrara el archivo al compilar el PDF.
- **Tiempo dedicado** — 40 min

### 2026-11-15 · `8f81571`

- **Autoría en Git** — Belinda Toaquiza (`BelindaTZ`).
- **Qué hice** — Completé la teoría de RPC, gRPC y Java RMI y actualicé la bibliografía y las evidencias de lectura.
- **Problema encontrado** — Dos fuentes iniciales eran anteriores a 2021 y la tabla comparativa ocupaba demasiado espacio.
- **Cómo lo resolví** — Reemplacé las fuentes antiguas por estudios de 2023 con DOI verificado, presenté la comparación en tres columnas breves y recompilé el PDF con una lista general de referencias.
- **Tiempo dedicado** — 50 min


### 2026-11-15 · `9c1094a`

- **Autoría en Git** — Belinda Toaquiza (`BelindaTZ`).
- **Qué hice** — Agregué un conversor de Celsius a Fahrenheit con Java RMI y renombré los PDF compartidos con los títulos de sus artículos.
- **Problema encontrado** — La suma propuesta inicialmente ya se había visto en clase y los nombres abreviados dificultaban identificar las fuentes.
- **Cómo lo resolví** — Probé la conversión en dos procesos Java, actualicé el ejemplo y la demo en las diapositivas, y comprobé que los PDF conservaran el mismo contenido tras el cambio de nombre.
- **Tiempo dedicado** — 45 min

### 2026-11-15 · Capturas de lectura

- **Autoría en Git** — Belinda Toaquiza (`BelindaTZ`).
- **Qué hice** — Preparé con asistencia de Codex cinco capturas de los artículos citados en mi bloque de RPC, gRPC y Java RMI.
- **Problema encontrado** — Los PDF completos y los nombres abreviados dificultaban localizar los pasajes usados en la exposición.
- **Cómo lo resolví** — Seleccioné las páginas, marqué los pasajes pertinentes y guardé las capturas con nombres que indican el tema, el autor y la página. Cada imagen incluye el DOI y conserva el número de página.
- **Tiempo dedicado** — 35 min.

### 2026-11-15 · `975c6bc`.

- **Autoría en Git** — Allison Mera (`ameraj2-bit`).
- **Qué hice** — Elaboré el diagrama de arquitectura del supuesto de SGRA distribuido en seis microservicios comunicados por gRPC y lo guardé como `diagrama/arquitectura-sgra.drawio`.
- **Problema encontrado** — El SGRA real es un monolito REST sin gRPC, por lo que había que definir un supuesto de distribución que respetara sus funciones reales. Además, el navegador no puede llamar directamente a servicios gRPC.
- **Cómo lo resolví** — Confirmé con la autora del sistema el flujo real (solicitud, aceptación o reprogramación, asistencia, carga masiva, reportes y chatbot) y asigné cada paso a un servicio. Agregué un API Gateway que recibe REST del cliente Angular y lo traduce a gRPC, y resalté en naranja el flujo de reprogramación entre Refuerzos y Notificaciones como ejemplo.
- **Tiempo dedicado** — 2 horas.

### 2026-11-15 · Notas grupales de la exposición (`61f34f5`)

- **Autoría en Git** — Belinda Toaquiza (`BelindaTZ`).
- **Qué hice** — Preparé el documento LaTeX de notas grupales y redacté el guion de teoría y de la demo de Java RMI.
- **Problema encontrado** — Faltaba integrar mi bloque y dejar espacio para que los demás integrantes añadieran sus notas y aportes.
- **Cómo lo resolví** — Organicé los cuatro bloques, reservé espacio para el bosquejo y dejé una declaración de uso de IA para todo el equipo. Verifiqué el PDF de cuatro páginas con las referencias al final.
- **Tiempo dedicado** — 15 min.

### 2026-11-15 · `a581146`, `df3a33e`, `0512854`

- **Autoría en Git** — Eduardo Reinoso (`ereinosov`).
- **Qué hice** — Preparé con asistencia de Claude mis dos diapositivas, CAP y PACELC y Modelos de comunicación, tomando como ejemplo la reprogramación de una sesión, y mi sección de las notas. Agregué una captura de la definición de PACELC en Ahmed et al. (2023).
- **Problema encontrado** — SGRA hoy es un monolito sin réplicas verificadas, así que el comportamiento ante una partición sale de leer el código y no de una medición. La guía pide además clasificar la comunicación (modelo, sincronía y mecanismo) y mi primera diapositiva solo mostraba flechas.
- **Cómo lo resolví** — Marqué como supuesto lo no comprobado y dejé la prueba de bloquear el puerto 5432 como propuesta, no ejecutada. Reemplacé la diapositiva por una tabla de modelo, sincronía y mecanismo, reutilicé la bibliografía del repositorio y cambié la fuente de PACELC por un artículo de 2023 con DOI.
- **Tiempo dedicado** — 2 horas.

### 2026-11-15 · `88dac8a`, `0231512`, `cb6166a`

- **Autoría en Git** — Allison Mera (`ameraj2-bit`).
- **Qué hice** — Preparé con asistencia de Claude mis tres diapositivas: presentación de SGRA con su escala, arquitectura con el diagrama exportado a PDF y transparencias de distribución. Agregué la referencia de las cifras de la UTEQ al archivo de bibliografía.
- **Problema encontrado** — Al compilar en Overleaf, las citas aparecían como claves en negrita y faltaba la figura del diagrama. Además, las primeras cifras de escala venían del PEDI 2024 y la página de la UTEQ mostraba datos más recientes.
- **Cómo lo resolví** — Comprobé que el problema era que Overleaf no tenía el archivo `.bib` ni la figura en la ruta esperada. Exporté el diagrama a PDF recortado, lo subí a `slides/figuras/` y verifiqué que la compilación completa con Biber mostrara las referencias numeradas. Actualicé la escala con las cifras de "UTEQ en cifras" (14 771 estudiantes de grado y 613 docentes) y reorganicé la presentación del sistema en una sola tabla.
- **Tiempo dedicado** — 1 hora.
