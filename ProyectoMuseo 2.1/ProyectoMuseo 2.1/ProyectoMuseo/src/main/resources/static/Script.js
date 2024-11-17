// Cargar murales en la tabla
function cargarMurales() {
    fetch('/api/murales') // URL del backend
        .then(response => response.json()) // Convertir respuesta a JSON
        .then(data => {
            let tabla = document.getElementById('tablaMurales').querySelector('tbody');
            tabla.innerHTML = ""; // Limpiar la tabla antes de agregar filas
            data.forEach(mural => {
                let fila = document.createElement('tr');
                fila.innerHTML = `
                    <td>${mural.idM}</td>
                    <td>${mural.titulo}</td>
                    <td>${mural.anoPublicacion}</td>
                    <td>${mural.materiales}</td>
                    <td>${mural.rating}</td>
                `;
                tabla.appendChild(fila);
            });
        })
        .catch(error => console.error('Error al cargar murales:', error));
}

// Cargar artistas en la tabla
function cargarArtistas() {
    fetch('/api/artistas') // URL del backend
        .then(response => response.json())
        .then(data => {
            let tabla = document.getElementById('tablaArtistas').querySelector('tbody');
            tabla.innerHTML = ""; // Limpiar la tabla antes de agregar filas
            data.forEach(artista => {
                let fila = document.createElement('tr');
                fila.innerHTML = `
                    <td>${artista.ida}</td>
                    <td>${artista.nombre}</td>
                    <td>${artista.apellido}</td>
                    <td>${artista.pais}</td>
                `;
                tabla.appendChild(fila);
            });
        })
        .catch(error => console.error('Error al cargar artistas:', error));
}

// Ejecutar las funciones cuando la página cargue
document.addEventListener('DOMContentLoaded', () => {
    cargarMurales();
    cargarArtistas();
});
