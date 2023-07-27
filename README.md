# Scaffolding of ScreenPlay Architecture

Gradle plugin to create a java application based on ScreenPlay Architecture following our best practices.

- [Scaffolding of ScreenPlay Architecture](#Scaffolding-of-ScreenPlay-Architecture)
- [Plugin Implementation](#plugin-implementation)
- [Tasks](#tasks)
  - [Generate Project](#generate-project)
  - [Generate Pipeline](#generate-pipeline)
  - [Generate Runners](#generate-runners)



# Plugin implementation 

To use the [plugin](#) you need Gradle version 7.4 or later, to start add the following section into your
**build.gradle** file.

```groovy
plugins {
    id "co.com.bancolombia.screenPlayArchitecture" version "1.0.0"
}
```
or if is a new project execute this script in the root directory of your project.
```sh
echo "plugins {
  id \"co.com.bancolombia.screenPlayArchitecture\" version \"1.0.0\"
}" > build.gradle
```
# Tasks
The Scaffolding ScreenPlay Architecture plugin will allow you run 2 tasks:

## Generate Project

The **`screenPlayArchitecture | spa`** task will generate a ScreenPlay architecture structure in your project, this task
has 3 optional parameters; `projectName` , `groupId` and `principalPackage`.
If you run this task on an existing project it will override the `build.gradle` file.
  - **`projectName`** `= ProjectName`: This parameter is going to specify name of the project. `Default value = Screenplay_architecture`
  - **`groupId`** `= <your.company.domain>`: You can specify your domain, this parameter going to use for package structure. `Default value = co.com.bancolombia.certificacion`
  - **`principalPackage`** `= package container`: This parameter going to like package container and is a complement for groupId. `Default value = screen`


```shell
gradle screenPlayArchitecture --projectName=Team_moduloPrueba --groupId=co.com.bancolombia.certificacion --principalPackage=moduloprueba
gradle spa --projectName=Team_moduloPrueba --groupId=co.com.bancolombia.certificacion --principalPackage=moduloprueba
```

**_The structure will look like this for java:_**

```bash
   📦NameProject
   ┣ 📂src
   ┃ ┣ 📂main
   ┃ ┃ ┗ 📂java
   ┃ ┃   ┗ 📂co
   ┃ ┃     ┗ 📂com
   ┃ ┃       ┗ 📂bancolombia
   ┃ ┃         ┗ 📂certificacion
   ┃ ┃           ┗ 📂[principalPackage]
   ┃ ┃             ┣ 📂exceptions
   ┃ ┃             ┣ 📂integrations
   ┃ ┃             ┣ 📂interactions
   ┃ ┃             ┣ 📂models
   ┃ ┃             ┣ 📂questions
   ┃ ┃             ┣ 📂tasks
   ┃ ┃             ┣ 📂userinterfaces
   ┃ ┃             ┗ 📂utils
   ┃ ┗ 📂test
   ┃   ┣ 📂java
   ┃   ┃ ┗ 📂co
   ┃   ┃   ┗ 📂com
   ┃   ┃     ┗ 📂bancolombia
   ┃   ┃       ┗ 📂certificacion
   ┃   ┃         ┗ 📂[principalPackage]
   ┃   ┃           ┣ 📂runners
   ┃   ┃           ┗ 📂stepdefinitions
   ┃   ┗ 📂resources          
   ┃     ┗ 📂features         
   ┣ 📜build.gradle
   ┗ 📜settings.gradle
   ```
## Generate Pipeline
The **`generatePipeline | gpl`** task will generate CI/CD pipeline inside root project, this task has two required parameters `name` and `type`
- **`name`** `= NamePipeline`: This parameter is going to specify the name of the pipeline. `field is requeired`
- **`type`** `= azure`: This parameter is going to specify the pipeline type. `field is requeired`

```shell
  gradle generatePipeline --name=pipelineCi --type=[type Pipeline] 
  gradle gpl --name=pipelineCi --type=[typePipeline] 
```

| Reference for **pipelineType** | Name           |
| ------------------------------ | -------------- |
| azure                          | Azure Pipeline |

## Generate Runners 
The **`generateRunner | grun`** task will generate runner class inside runners package, this task has one required parameter `name`
- **`name`** `= NameRunner`: This parameter is going to specify the name of the runner class. `field is requeired`

```shell
  gradle generateRunner --name=runnerClassName
  gradle grun --name=runnerClassName
```

