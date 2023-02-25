#!/usr/bin/zsh


mvn_install() {
  mvnd source:jar-no-fork install
}

npm_install() {
  npm i && npm run build
}


module="user"
cd dist/"${module}"/server
#sed -i -e 's/<build> <sourceDirectory>src/main/java</sourceDirectory> </build>/<build>        <sourceDirectory>src/main/java</sourceDirectory>        <plugins>            <plugin>                <groupId>org.apache.maven.plugins</groupId>                <artifactId>maven-source-plugin</artifactId>                <version>3.2.1</version>            </plugin>        </plugins>    </build>/g' pom.xml
mvn_install
cd ../../..
cd dist/"${module}"/client
npm_install

