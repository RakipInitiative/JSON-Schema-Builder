# JSON Schema Builder

This service allows you to build JSON schemas using the JSON Schema Builder tool.

Access Web-App here: https://jsb.starlingcloud.dev/index.html

## Prerequisites

- Java Runtime Environment (JRE) installed
- Git installed (for cloning the repository)
- Access to the internet (to download dependencies)

## Deployment Instructions

1. Clone the repository:

   ```shell
   git clone https://github.com/example/JSON-Schema-Builder.git

2. Systemd Unit Configuration

    Create a unit file called JSON-Schema-Builder.service in /etc/systemd/system/ with the following content:
    ```shell
    [Unit]
    Description=JSON Schema Builder
    After=syslog.target network.target
    
    [Service]
    SuccessExitStatus=143
    User=root
    Group=root
    Type=simple
    Environment="JAVA_HOME=/path/to/jvmdir"
    WorkingDirectory=/home/info/JSON-Schema-Builder/BE/kida-backend-main/
    ExecStart=sh start.sh
    ExecStop=/bin/kill -15 $MAINPID
    
    [Install]
    WantedBy=multi-user.target  
3. Add start.sh
   ```shell
   #!/bin/bash

   LIB_DIR="/home/info/JSON-Schema-Builder/BE/kida-backend-main"
   JAR_FILE="/home/info/JSON-Schema-Builder/BE/kida-backend-main/target/kida-editor-backend-0.10.0.jar"

   CLASSPATH="$LIB_DIR/swagger-codegen-cli-3.0.34.jar"

   java -cp "$CLASSPATH" -jar "$JAR_FILE"

4. Enable and start the service:
   ```shell
   systemctl enable JSON-Schema-Builder.service
   systemctl start JSON-Schema-Builder.service


5. Stopping the Service:
   To stop the service, execute the following command:
   ```shell
    systemctl stop JSON-Schema-Builder.service


