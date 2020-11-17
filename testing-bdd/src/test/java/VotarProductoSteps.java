import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VotarProductoSteps {
    @Given("el sistema muestra en el card del producto y en el perfil un icono votar")
    public void elSistemaMuestraEnElCardDelProductoYEnElPerfilUnIconoVotar() {
    }

    @When("el usuario hace click en el icono {string}")
    public void elUsuarioHaceClickEnElIcono(String arg0) {
    }

    @Then("el sistema valida mi voto")
    public void elSistemaValidaMiVoto() {
    }

    @And("el sistema cambia a color verde el marco del card del producto votado")
    public void elSistemaCambiaAColorVerdeElMarcoDelCardDelProductoVotado() {
    }

    @Then("el sistema valida mi petición")
    public void elSistemaValidaMiPetición() {
    }

    @And("el sistema cambia a color predeterminado el marco del card del producto votado")
    public void elSistemaCambiaAColorPredeterminadoElMarcoDelCardDelProductoVotado() {
    }

    @Given("el sistema muestra la sección de {string} en el perfil del usuario")
    public void elSistemaMuestraLaSecciónDeEnElPerfilDelUsuario(String arg0) {
    }

    @When("el usuario hace click en la sección {string}")
    public void elUsuarioHaceClickEnLaSección(String arg0) {
    }

    @Then("el sistema muestra una lista de productos votados y los iconos {string} y {string}")
    public void elSistemaMuestraUnaListaDeProductosVotadosYLosIconosY(String arg0, String arg1) {
    }

    @Given("el sistema muestra las notificaciones en la seccion \"Notificaciones")
    public void elSistemaMuestraLasNotificacionesEnLaSeccionNotificaciones() throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }

    @And("el sistema muestra notificaciones sin leer en la sección de {string}")
    public void elSistemaMuestraNotificacionesSinLeerEnLaSecciónDe(String arg0) {
    }

    @When("el usuario selecciona las notificaciones")
    public void elUsuarioSeleccionaLasNotificaciones() {
    }

    @Then("el sistema muestra las notificaciones")
    public void elSistemaMuestraLasNotificaciones() {
    }

    @And("el usuario revisa las notificaciones acerca del producto que obtuvo los votos requeridos")
    public void elUsuarioRevisaLasNotificacionesAcercaDelProductoQueObtuvoLosVotosRequeridos() {
    }
}