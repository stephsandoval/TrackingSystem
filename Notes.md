## NOTAS DEL AVANCE DEL PROYECTO

### DÍA: 30 de setiembre
> Se han creado las clases de los siguientes paquetes:
> + Flowers
> + GUI
> + People

También se comenzó a trabajar en las clases del paquete Orders.

Cabe notar que, por ahora, las clases que están mejor implementadas (completas en su totalidad) son las del paquete Flowers. Las otras clases aun necesitan algunos detalles extras.

##### CAMBIOS HECHOS
> Al final se terminó agregando la clase 'CatalogueEntry' y una clase *helper*: 'Range'. Range es para poder controlar intervalos, guarda un máximo y un mínimo. La necesidad de las dos clases surgió porque el precio de las flores varía según el largo del tallo. Y en el catálogo no iba a pretender guardar un precio para cada posible largo de tallo, menos teniendo en cuenta que los tallos pueden ir con decimales.

> Dado esto, se decidió guardar los datos en el catálogo como intervalos. Intervalos del largo del tallo e intervalos de los precios. Por eso la necesidad de las dos clases. 

> **Nota extra:** por el momento el catálogo se trata como un csv y no como algo del json.

#### NOTAS PARA FUTUROS AVANCES
> Hace falta considerar si el 'equal' de Flower está bien como está ahora (solo comparando el tipo y la especie) o si le debería agregar también el largo del tallo. O tratar el largo dentro de un intervalo. 