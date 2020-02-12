package com.example.demoapp.utils;

import java.util.Random;

public class Utils {
    public static String category=null;

   static String[] url={"https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
            "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
            "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
            "https://homepages.cae.wisc.edu/~ece533/images/barbara.bmp",
            "https://homepages.cae.wisc.edu/~ece533/images/monarch.png",
            "https://homepages.cae.wisc.edu/~ece533/images/zelda.png",
            "https://homepages.cae.wisc.edu/~ece533/images/pool.png",
            "https://homepages.cae.wisc.edu/~ece533/images/monarch.png",
            "https://homepages.cae.wisc.edu/~ece533/images/lena.ppm",
            "https://homepages.cae.wisc.edu/~ece533/images/Lenaclor.ppm",
            "https://homepages.cae.wisc.edu/~ece533/images/fruits.png",
            "https://homepages.cae.wisc.edu/~ece533/images/frymire.png",
            "https://homepages.cae.wisc.edu/~ece533/images/goldhill.png",
           "https://assets.entrepreneur.com/content/3x2/2000/20191219170611-GettyImages-1152794789.jpeg"
    };

    public static String getImageUrl(){
        return url[new Random().nextInt(url.length)];
    }

    public static Double totalCost=0.0;
}
