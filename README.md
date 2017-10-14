# daggertwoeleven
This project showcases various use-cases of dependency-injection using Dagger >= 2.11.

## Use-Cases
### Application extending DaggerApplication
1. `AndroidManifest.xml` refers to the `Application`-class
   ```xml
   <application
           android:name=".App"
   ``` 
2. `Application`-class extends from `DaggerApplication` 
   ```java
   public class App extends DaggerApplication 
   ```
3. `@dagger.Component` (inside `Application`-class or in a separate file)  **must** contain module `AndroidSupportInjectionModule.class`
    ```java
    @dagger.Component(modules = {AndroidSupportInjectionModule.class})
    interface Component extends AndroidInjector<App> {
        @dagger.Component.Builder
        abstract class Builder extends AndroidInjector.Builder<App> {}
    }
    ```
4. `Application`-class **must** `@Override` the method `applicationInjector()`
    ```java
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApp_Component
                .builder()
                .create(this);
    }
    ```
    The class`DaggerApp_Component` will be generated automatically by the annotationProcessor.\
    If not, try building the project and try again.\
    If it's still not working there's something wrong.
## License

    Copyright 2017 Jan Grünewald

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
