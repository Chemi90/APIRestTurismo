# APIRestTurismo
API Rest Turismo
Descripción
API Rest para la gestión de información turística, incluyendo hoteles, eventos y puntos de interés. Esta API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los recursos mencionados.

Configuración y Ejecución
Requisitos Previos
Java 11 o superior
MySQL 8.0 o superior
Maven 3.6.3 o superior (opcional si usas Spring Boot Maven Plugin)

Endpoints

Creados todos en la carpeta resources

MostrarHoteles

Entrada
GET http://localhost:8080/api/hoteles/

Salida
{
    "id": 1,
    "nombre": "Hotel Vista Mar",
    "direccion": "Calle Sol, 123, Ciudad Playa",
    "estrellas": 4,
    "telefono": "555-123456",
    "email": "info@hotelvistamar.com",
    "sitioWeb": "http://www.hotelvistamar.com"
  }

HotelPorID

Entrada
GET http://localhost:8080/api/hoteles/2

Salida
{
  "id": 2,
  "nombre": "Gran Hotel Montaña",
  "direccion": "Avenida Sierra, 456, Pueblo Montaña",
  "estrellas": 5,
  "telefono": "555-654321",
  "email": "contacto@granhotelmontana.com",
  "sitioWeb": "http://www.granhotelmontana.com"
}

CrearHotel

Entrada
POST http://localhost:8080/api/hoteles/?token=t0k3n
Content-Type: application/json

{
  "nombre": "Hotelazo",
  "direccion": "Calle Ejemplo, 123",
  "estrellas": 5,
  "telefono": "987654321",
  "email": "contacto@ejemplodehotel.com",
  "sitioWeb": "http://www.ejemplodehotel.com"
}

ModificarHotelExistente

Entrada
PUT http://localhost:8080/api/hoteles/id?token=t0k3n
Content-Type: application/json
Accept: application/json

{
  "nombre": "Hoteles Ejemplo Actualizado",
  "direccion": "Calle Real, 456",
  "estrellas": 5,
  "telefono": "987654321",
  "email": "info@hotelejemploactualizado.com",
  "sitioWeb": "http://www.hotelejemploactualizado.com"
}

EliminarHotelID

Entrada
DELETE http://localhost:8080/api/hoteles/id?token=t0k3n

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - vea el archivo [LICENSE](LICENSE) para detalles.
