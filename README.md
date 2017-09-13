# webjars-sample
Here is an example of WebJar usage in CUBA.platform based project. It shows how you can use WebJars to create new UI component, in this case - Carousel.


## Overview

Reference:
> WebJars are client-side web libraries (e.g. jQuery & Bootstrap) packaged into JAR (Java Archive) files ([WebJar.org](https://www.webjars.org/)).
>
In this example "jrcarousel" WebJar is used: [GitHub](https://github.com/vinayakjadhav/jRCarousel)

## Running the application
To run this sample execute in command line the following:

    gradle setupTomcat startDb createDb assemble deploy start

When the application starts, it will be available by URL: http://localhost:8080/app

To open the demo choose in menu: Application -> Carousel demo page