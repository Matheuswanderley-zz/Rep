# Back and do projeto WALED - Alugue Agora

O projeto Lombok gera os getters e setters, assim como implementa equals, hashcode e toString em tempo de compilação. 
Para poder funcionar o mesmo deve ser configurado na IDE.
Como configurar: http://jnb.ociweb.com/jnb/jnbJan2010.html#installation

Instalar manualmente o drive jdbc do oracle
mvn install:install-file -Dfile={Path/to/your/ojdbc7.jar}
      -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0 -Dpackaging=jar

Se estiver no diretorio do jar usar o comando:
mvn install:install-file -Dfile=ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0 -Dpackaging=jar
