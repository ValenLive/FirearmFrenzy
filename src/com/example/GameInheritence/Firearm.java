package com.example.GameInheritence;
import java.util.Scanner;

public class Firearm {
    private String weaponType;
    private String manufacture;

    private String sign = "<";
    private String fireSelectorMode = "Safe";

    private int magazineSize;
    private int bulletsCount;

    private int bulletsInMagazine;
    private double malfunctionPropability;

    public Firearm() {
        this("0", "0", 0, 0, 0, 0);
    }

    public Firearm(String weaponType, String manufacture, int magazineSize, int bulletsCount, int bulletsInMagazine, double malfunctionPropability) {
        this.weaponType = weaponType;
        this.manufacture = manufacture;
        this.magazineSize = magazineSize;
        this.bulletsCount = bulletsCount;
        this.bulletsInMagazine = bulletsInMagazine;
        this.malfunctionPropability = malfunctionPropability;
    }

    // Display commands
    public void showCommands() {
        System.out.println("Displaying available commands.. stats, reload, inspect mag, inspect selector, switch fire mode, shoot");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(">> ");
            String newInput = input.nextLine().toLowerCase();
            if (newInput.equals("stats")) {
                showStats();
            } else if (newInput.equals("reload")) {
                reload();
            } else if (newInput.equals("inspect mag")) {
                inspectMagazine();
            } else if (newInput.equals("switch fire mode")) {
                switchFireMode();
            } else if (newInput.equals("inspect selector")) {
                displayFireModeSelector(sign);
            } else if (newInput.equals("shoot")) {
                shoot();
            } else if (newInput.equals("inspect gun")) {
                displayGun();
            } else if (newInput.equals("exit")) {
                System.out.println("Exiting current simulation..");
                break;
            } else {
                System.out.println("Incorrect command. Please follow instructions mentioned above.");
            }
        }

    }

    //Displaying available weapon
    public void displayGun() {
        System.out.println(
                        " +--^----------,--------,-----,--------^-,\n" +
                        " | |||||||||   `--------'     |          O\n" +
                        " `+---------------------------^----------|\n" +
                        "   `\\_,---------,---------,--------------'\n" +
                        "     / XXXXXX /'|       /'\n" +
                        "    / XXXXXX /  `\\    /'\n" +
                        "   / XXXXXX /`-------'\n" +
                        "  / XXXXXX /\n" +
                        " / XXXXXX /\n" +
                        "(________( ");
    }

    //Display stats
    public void showStats() {
        System.out.println("Displaying Stats..");
        System.out.println(weaponType + " made by " + manufacture + "\n" +
                "Magazine size: " + magazineSize + "\nBullets in box: " +
                bulletsCount + "\nBullets in magazine: " + bulletsInMagazine +
                "\nFire selector mode: " + fireSelectorMode);
    }

    //Shoot
    public void shoot() {
        if (!fireSelectorMode.equals("Safe")) {
            System.out.print("You are in firing ready position! Finger on the trigger!");
            Scanner input = new Scanner(System.in);
            while (bulletsInMagazine >= 0) {
                String newInput = input.nextLine();
                if (bulletsInMagazine > 0 && newInput.equals("")) {
                    System.out.println(" _..  _....... __........._\n" +
                            "--== ||:------'||'----------)  ))-> P O W!\n" +
                            " --.  \\\\_______\\\\________.-'\n");
                    bulletsInMagazine--;
                }
                if (bulletsInMagazine == 0 && newInput.equals("")) {
                    System.out.print("* c l i c k *");
                }
                if (newInput.equals("disengage")) {
                    System.out.println("Good shooting, buddy!");
                    System.out.println("Disengaging from firing position!");
                    break;
                }
            }
        } else {
            System.out.println("* c l i c k *");
        }
    }

    //Switch fire mode
    public void switchFireMode() {
        Scanner input = new Scanner(System.in);
        System.out.println("Switch fire mode: \n1.Safe; 2.Semi; 3.Automatic");
        System.out.print("> ");
        switch (input.nextInt()) {
            case 1:
                fireSelectorMode = "Safe";
                sign = "<";
                break;
            case 2:
                fireSelectorMode = "Semi";
                sign = "^";
                break;
            case 3:
                fireSelectorMode = "Automatic";
                sign = ">";
                break;
            default:
                System.out.println("Switch fire mode using 1, 2, 3 inputs.w.");
        }
        System.out.println("Switching firing mode..");
        displayFireModeSelector(sign);
        System.out.println(fireSelectorMode + " firing mode switched successfully!");
    }

    //Display selector
    public void displayFireModeSelector(String sign) {
        System.out.println("Inspecting selector...");
        System.out.println("._________________.");
        System.out.println("      [Semi]\n         |\n[Safe] - " + sign + " - [Auto]");
        System.out.println("'-----------------'");
    }

    //Inspect mag
    public void inspectMagazine() {
        System.out.println("Inspecting magazine...");
        for (int i = bulletsInMagazine; i > 0; i--) {
            System.out.print("|==>| ");
        }
        for (int i = magazineSize - bulletsInMagazine; i > 0; i--) {
            System.out.print("|___| ");
        }
        if (bulletsInMagazine == magazineSize) {
            System.out.println("\nFull mag! Rip and tear until it's done!");
        } else if (bulletsInMagazine == 0) {
            System.out.println("\nThis bitch is empty!");
        } else if (bulletsInMagazine < magazineSize / 2 - magazineSize / 6) {
            System.out.println("\nLess than half, cap!");
        } else if (bulletsInMagazine > magazineSize / 2 + magazineSize / 6) {
            System.out.println("\nMore than a half left, ready to ooga some boogas!");
        } else {
            System.out.println("\nAbout half to go..");
        }
    }

    //Reload
    public void reload() {
        System.out.println("Reloading...");
        bulletsCount += bulletsInMagazine;
        bulletsInMagazine -= bulletsInMagazine;
        for (int i = 0; i < magazineSize; i++) {
            System.out.print("|___| ");
        }

        System.out.println("\n...");

        bulletsCount -= magazineSize;
        bulletsInMagazine += magazineSize;
        for (int i = 0; i < magazineSize; i++) {
            System.out.print("|==>| ");
        }

        System.out.println("\nReloading complete!");
    }

    public void inspect() {

    }

    public void bash() {

    }

    public void malfunction() {

    }

    public void drop() {

    }

}
