# **Challenge Conversor**

## **Resumen**

Se ha realizado un sencillo programa de escritorio para realizar la conversión de monedas de Soles Peruanos (S/.) a otras divisas, y también un conversor de temperaturas (°C, °F y K).

## **Funcionalidades**
1. **Conversor de mondeas o divisas**: Permite escoger entre algunas divisas teniéndolas cargadas previamente su factor de conversión de Soles a la divisa especificada.

2. **Conversor de temperaturas**: Permite escoger una unidad de temperatura inicial y una unidad de temperatura final.

## **Validaciones y Funcionalidades secundarias**
1. Para ambos conversores se valida que se ingrese un dato y que sea de tipo int o double. Sino no se permite continuar.
2. Si no se ingresa un valor se hace focus en el campo.
3. Si se ingresa un valor no valido se selecciona el texto inválido y se hace focus en el campo.
4. Si no seleccionan un valor de los campos desplegables, no se continua y se hace focus a dicho campo.
5. Si se cambia un dato de alguno de los campos se borra el valor resultado, para no generar confusiones.

## **Estructura de Carpetas**

El proyecto contiene dentro de la carpeta `src` las siguientes subcarpetas:

- `main`: Aquí se encuentra la clase principal para levantar el programa.
- `view`: En este folder se encuentran las clases que construyen la interfaz gráfica. **No se utilizó ninguna herramienta de construcción de interfaces gráficas.**
- `valores`: Se creó clases Enum para los tipos de divisas y los tipos de unidades de temperatura.
- `funcionalidades`: En este folder se almacenó la lógica con las operaciones matemáticas para las diferentes combinaciones de conversión de temperatura. *Nota*: La conversión de monedas al ser más directa se realizó directamente en sus clases en la carpeta `view`


