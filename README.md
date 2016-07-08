# JEncryptor

Biblioteca java para criptografia de textos. Sua utilização consiste apenas em informar a `Chave de Criptografia` personalizada e acionar os 
métodos `convertToHex(String Text)` e `convertToText(String hex)` passando o Texto a ser criptografado e o Texto a ser descriptografado
respectivamente.

### Iniciando

Gerar a biblioteca JAR e instalar no repositório local:

    $ git clone git://github.com/henrique-gouveia/jencryptor.git
    $ cd jencryptor
    $ mvn install

Adicionar a dependência no pom.xml:

    <dependency>
      <groupId>br.com.ndevfactory</groupId>
      <artifactId>jencryptor</artifactId>
      <version>1.0.0-SNAPSHOT</version>
      <scope>compile</scope>
    </dependency>