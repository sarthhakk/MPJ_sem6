class Hillstations {

    void famousfor() {
        System.out.println("Hill station is famous for natural beauty.");
    }

    void famousfood() {
        System.out.println("Hill station has traditional food.");
    }
}


class Manali extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Manali is famous for snow and adventure sports.");
    }

    @Override
    void famousfood() {
        System.out.println("Manali is famous for Siddu.");
    }
}


class Ooty extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Ooty is famous for tea gardens.");
    }

    @Override
    void famousfood() {
        System.out.println("Ooty is famous for chocolates.");
    }
}


class Munnar extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Munnar is famous for tea plantations.");
    }

    @Override
    void famousfood() {
        System.out.println("Munnar is famous for Kerala food.");
    }
}