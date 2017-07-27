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
    
