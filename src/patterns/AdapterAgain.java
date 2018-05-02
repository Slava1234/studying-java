package patterns;

public class AdapterAgain {
    public void start() {
        WeaponStart weaponStart = new WeaponStart();
        weaponStart.start(new M16());
    }
}

class WeaponStart {
    public void start(Weapon weapon) {
        weapon.shoot();
    }
}



interface Weapon {
    public void shoot();
}

class M16 implements Weapon {
    @Override
    public void shoot() {
        System.out.println("m16 is shooting");
    }
}


interface Fart {
    public void fart();
}

class VadimPetrovich implements Fart {
    @Override
    public void fart() {
        System.out.println("Vadim Petrovich is farting");
    }
}


class VadimPetrovichWrapper implements Weapon {
    private VadimPetrovich vadimPetrovich;

    public void VadimPetrovich (VadimPetrovich vadimPetrovich) {
        this.vadimPetrovich = vadimPetrovich;
    }

    @Override
    public void shoot() {
        vadimPetrovich.fart();
    }
}












