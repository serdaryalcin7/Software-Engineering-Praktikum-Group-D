Feature: EntryTest
  Scenario: Erstellung eines Entries
    Given User klickt new Entry
    When User gibt richtige Daten ein
    And fuer Titel
    And fuer Location
    And fuer Datum
    And fuer Text
    And fuer Description
    And fuer Category
    And fuer Star
    Then Entry created succesfully and saved in overview