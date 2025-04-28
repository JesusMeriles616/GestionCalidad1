FROM jenkins/jenkins:lts

# Evitar la instalación inicial de plugins
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

# Instalar plugins necesarios
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Crear usuario administrador
ENV JENKINS_USER=admin
ENV JENKINS_PASS=admin

# Puerto por defecto
EXPOSE 8080 