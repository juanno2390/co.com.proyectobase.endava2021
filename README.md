# co.com.proyectobase.endava2021
# 05/02/2021 
# Juan Esteban Acevedo Muñoz

proyecto de automatización Cucumber + Serenity en lenguaje Java y gestor de dependencias Gradle

Realizado en intellij IDEA 2019.3.3 (COMUNITY EDITION) con
gradle v6.4.1,
maven v3.6.3,
jdk v1.8,
jvm/jre v1.8.0_241,
Ejecucion en Navegador Google Chrome:ChromeDriver

Cambios realizados al codigo original enviado de reto automatizacion (*Ejemplo Reto Enviado: src->test->java->co.com.proyectobase->endavatestbase->runners->AppTest )
	-Ajuste del identificador elemento css (Se cambio el div por span):: 
		//driver.findElement(By.cssSelector("div[data-component-id='1']")).click();  
		Driver.findElement(By.cssSelector("span[data-component-id='1']")).click();
	-Ajuste en el assertEquals (Se añade al identificador css .getText())
		//Assert.assertEquals(driver.findElement(By.cssSelector("span[id='productTitle']")),"A Practitioner's Guide to Software Test Design");
		Assert.assertEquals(driver.findElement(By.cssSelector("span[id='productTitle']")).getText(),"A Practitioner's Guide to Software Test Design");
	-Ajuste en el texto de validacion AssertTrue (para la automatizacion en pageobject y screenplay se generan 2 escenarion para cuando se muestra/no se muetra preseleccionado el tab Paperback)
		//Assert.assertTrue(driver.findElement(By.cssSelector("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isDisplayed(),"Paperback tab was not shown pre-selected ");
        Assert.assertTrue(driver.findElement(By.cssSelector("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isDisplayed(),"Paperback tab was shown pre-selected ");

::IMPORTANTE::
Pasos para su correcto funcionamiento y utilizacion:
-Asegurarse de tener instalado y configurado las variablers de entorno jdk, gradle y mavencomo con las versiones igual o superiores a las utilizadas en el proyecto. 

-Clonar desde github a traves del enlace https://github.com/juanno2390/co.com.proyectobase.endava2021.git en su maquina local

-Importar el proyecto con gradle (preferencia en Intellij)

- El setting.Gradle contiene: rootProject.name = 'co.com.proyectobase.endava2021'


-Para la ejecución se puede dirigir a los Runners a continuacion (todos comparten el mismo .feature y se diferencian en la estructura utilizada para la automatización)
		*Ejemplo Reto Enviado:                src->test->java->co.com.proyectobase->endavatestbase->runners->AppTest 
			Es posible que requiera configuracion adicional:: 
								Run->Edit configurations...->TestNG->VM options: -ea -Dtestng.dtd.http=true)
								Nota: En intellij puede requerir en settings Buid toold Gradle->Run test using: Intellij IDEA
		*Automatizacion en PageObject:        src->test->java->co.com.proyectobase->pageobject->runners->RunnerAppTest
		*Automatizacion en Screenplay:        src->test->java->co.com.proyectobase->screenplay->runners->RunnerTags
        *features:                            src->test->resources->features->appTest.feature

-Para visualizacion del reporte en serenity de la ultima ejecucion realizadas (Solo disponible para automatizacion realizada en PageObject y Screenplay). Abrir "index.html" ubicado en la siguiente ruta:
	target->site->serenity->index.html
	Nota: En intellij puede requerir en settings Buid toold Gradle->Run test using: Gradle(Default)
	
	
	
	
	
Quedo atento a cualquier inquietud, pueden escribirme al correo juanno23@hotmail.com



