// Mock data para usuarios
let usuarios = [];

// Función para guardar un nuevo usuario
async function guardarUsuario(event) {
    event.preventDefault();
    
    const nombre = document.getElementById('nombre').value;
    const email = document.getElementById('email').value;
    
    try {
        const response = await fetch('/api/usuarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                nombre: nombre,
                email: email,
                edad: edad,
                tipo: tipo
            })
        });

        if (response.ok) {
            // Limpiar el formulario
            document.getElementById('userForm').reset();
            
            // Mostrar mensaje de éxito
            alert('Usuario guardado exitosamente!');
        } else {
            throw new Error('Error al guardar el usuario');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('Hubo un error al guardar el usuario');
    }
}

// Agregar el evento submit al formulario
document.getElementById('userForm').addEventListener('submit', guardarUsuario); 
