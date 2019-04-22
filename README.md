# Conference Scheduler
Conference scheduler app creates a one day schedule for a provided speech list. Parallel tracks are generated if necessary. 

# Deployment 
Open terminal, browse to conference folder and run the command
`docker-compose up`
This will build and start everything up.
Navigate to `http://localhost:8081` to view the application.


# ConferenceScheduler Client

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.3.8.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

# ConferenceScheduler Server

Spring boot project. To make changes, modify the code and run 'mvn package'. This will replace the provided jar file. Then run the application using 'docker-compose up --build'.  
