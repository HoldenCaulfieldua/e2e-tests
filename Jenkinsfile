  // Change `url` value to your own
    def inputParams=['test','report']    
    
    // Change `message` value to the message you want to display
    // Change `description` value to the description you want
    def selectedProperty = input( id: 'userInput', message: 'Choose action', 
        parameters: [ [
          $class: 'ChoiceParameterDefinition', 
          choices: inputParams, 
          description: 'Properties', 
          name: 'prop'] ])
    
    println "Property: $selectedProperty"
    
    // Change `job` value to your downstream job name
    // Change `name` value to the name you gave the string parameter in your downstream job

 @DataBoundConstructor
    public ChoiceParameterDefinition(String name, String choices, String description) {
        super(name, description);
        this.choices = Arrays.asList(choices.split(CHOICES_DELIMITER));
        defaultValue = null;
    }
