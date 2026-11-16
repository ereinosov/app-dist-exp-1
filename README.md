# EXP-1 · Análisis de un sistema distribuido real

![Asignatura](https://img.shields.io/badge/Asignatura-Aplicaciones%20Distribuidas%20(ISR--701)-1f6feb)
![Actividad](https://img.shields.io/badge/Actividad-GA--SUM--02%20%C2%B7%20EXP--1-2da44e)
![LaTeX](https://img.shields.io/badge/LaTeX-pdflatex%20%2B%20biber-008080)
![Sistema](https://img.shields.io/badge/Sistema-SGRA-orange)

Universidad Técnica Estatal de Quevedo (UTEQ), Facultad de Ciencias de la Computación, Carrera de Software. Séptimo nivel, paralelo A. Grupo LMRT.

Exposición grupal del primer corte sobre RPC, gRPC y Java RMI, aplicada a un sistema real.

## Integrantes

| Integrante |
|---|
| Loor Mendoza Byron Daniel |
| Mera Jumbo Allison Michelle |
| Reinoso Vélez Eduardo David |
| Toaquiza Zambrano Belinda Betzabeth |

## Sistema analizado

Sistema de Gestión de Refuerzos Académicos (SGRA): [back-SGRA](https://github.com/KhrizGomez/back-SGRA) y [front-SGRA](https://github.com/KhrizGomez/front-SGRA).

El SGRA real es un monolito REST. El análisis de RPC, gRPC y Java RMI se apoya en el diseño distribuido supuesto de [`diagrama/arquitectura-sgra.drawio`](diagrama/arquitectura-sgra.drawio), y lo no verificado en el código real se marca como supuesto.

## Video del ensayo

Pendiente.

## Estructura

```
.
├── README.md
├── BITACORA.md
├── slides/            diapositivas (Beamer) y su PDF
├── notas/             notas de la presentación y su PDF
├── diagrama/          diagrama editable de la arquitectura (.drawio)
├── demo/rmi/          ejemplo simple con Java RMI
└── evidencias/
    ├── capturas-fuentes/   capturas de los artículos, PDF de las fuentes y referencias.bib
    └── esquema-mano/       bosquejo inicial dibujado a mano
```

## Compilación

- **Compilador:** `pdflatex` y `biber`, con TeX Live o MiKTeX.
- **Archivos principales:** `slides/main.tex` (diapositivas) y `notas/main.tex` (notas).
- **Bibliografía:** `evidencias/capturas-fuentes/referencias.bib`, compartida por ambos documentos.
- **Orden de comandos**, dentro de `slides/` y luego dentro de `notas/`:

```
pdflatex main
biber main
pdflatex main
pdflatex main
```

- **Dependencias:** paquetes `beamer`, `biblatex`, `babel` (español), `tikz`, `booktabs`, `tabularx`, `mathptmx`, `hyperref` y `geometry`.
