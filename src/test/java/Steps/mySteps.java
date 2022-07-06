package Steps;

import at.jku.se.diary.DiaryEntry;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;

public class mySteps {

    DiaryEntry d = new DiaryEntry();

    @Given("User klickt new Entry")
    public void user_klickt_new_entry() {

    }

    @When("User gibt richtige Daten ein")
    public void user_gibt_richtige_daten_ein() {

    }

    @When("fuer Titel")
    public void fuer_titel() {
        d.setTitle("Title");
        if (d.getTitle() != null){
            System.out.println("Gültiger Input fuer Titel wurde eingegeben");
        }

    }
    @When("fuer Location")
    public void fuer_location() {
        d.setLocation("Location");
        if (d.getLocation() != null) {
            System.out.println("Gültiger Input fuer Location wurde eingegeben");

        }
    }
    @When("fuer Datum")
    public void fuer_datum() {
        d.setDate(LocalDate.now());
        if (d.getDate() != null) {
            System.out.println("Gültiger Input fuer Datum wurde eingegeben");
        }
    }
        @When("fuer Text")
        public void fuer_text() {
            d.setText("Text");
            if (d.getText() != null){
                System.out.println("Gültiger Input fuer Text wurde eingegeben");
            }

    }
    @When("fuer Description")
    public void fuer_description() {
        d.setDescription("Description");
        if (d.getDescription() != null) {
            System.out.println("Gültiger Input fuer Description wurde eingegeben");
        }
    }
    @When("fuer Category")
    public void fuer_category() {
        d.setCategory("Category");
        if (d.getCategory() != null) {
            System.out.println("Gültiger Input fuer Category wurde eingegeben");

        }

        }
    @When("fuer Star")
    public void fuer_star() {
        d.setStar("Star");
        if (d.getStar() != null) {
            System.out.println("Gültiger Input fuer Star wurde eingegeben");
        }

        }
    @Then("Entry created succesfully and saved in overview")
    public void entry_created_succesfully_and_saved_in_overview() {

    }
}
