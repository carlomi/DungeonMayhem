package Player;

import Cartas.*;
import Habilidades.*;
import Habilidades.Azzan.AzzanH1;
import Habilidades.Azzan.AzzanH2;
import Habilidades.Azzan.AzzanH3;
import Habilidades.Blorp.BlorpH1;
import Habilidades.Blorp.BlorpH2;
import Habilidades.Blorp.BlorpH3;
import Habilidades.Delilah.DelilahH1;
import Habilidades.Delilah.DelilahH2;
import Habilidades.Delilah.DelilahH3;
import Habilidades.Lia.LiaH1;
import Habilidades.Lia.LiaH2;
import Habilidades.MinscAndBoo.MinscH1;
import Habilidades.MinscAndBoo.MinscH2;
import Habilidades.MinscAndBoo.MinscH3;
import Habilidades.Sutha.SuthaH1;
import Habilidades.Sutha.SuthaH2;
import Habilidades.Sutha.SuthaH3;

import java.util.ArrayList;
import java.util.List;



public class Personaje {
    private String nombre;
    private String descripcion;
    private String color;
    private List<Carta> mazo;
    private boolean enUso;


    //Constructor
    public Personaje(String nombre, String descripcion, String color, List<Carta> mazo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.color = color;
        this.mazo = mazo;
        this.enUso = false;
    }

    //Metodos
    public static List<Personaje> generarPersonajes(){
        //Inicializa una lista por personaje que va a tener sus respectivas cartas
        List<Personaje> personajes = new ArrayList<>();

        List<Carta> mazo1 = new ArrayList<>();
        List<Carta> mazo2 = new ArrayList<>();
        List<Carta> mazo3 = new ArrayList<>();
        List<Carta> mazo4 = new ArrayList<>();
        List<Carta> mazo5 = new ArrayList<>();
        List<Carta> mazo6 = new ArrayList<>();

        mazo1 = generarCartasAzzan();
        mazo2 = generarCartasBlorp();
        mazo3 = generarCartasDelilah();
        mazo4 = generarCartasLia();
        mazo5 = generarCartasMinscAndBoo();
        mazo6 = generarCartasSutha();

        Personaje Azzan = new Personaje("Azzan", "Agresivo","Amarillo", mazo1);
        Personaje Blorp = new Personaje("Blorp", "Defensivo", "Cesleste", mazo2);
        Personaje Delilah = new Personaje("Delilah", "Neutral","Morado", mazo3);
        Personaje Lia = new Personaje("Lia", "Agresiva","Rojo", mazo4);
        Personaje MinscAndBoo = new Personaje("Minsc and Boo", "Defensivos", "Azul", mazo5);
        Personaje Sutha = new Personaje("Sutha", "Neutral", "Rosado", mazo6);

        personajes.add(Azzan);
        personajes.add(Blorp);
        personajes.add(Delilah);
        personajes.add(Lia);
        personajes.add(MinscAndBoo);
        personajes.add(Sutha);

        return personajes;
    }

    public static List<Carta> generarCartasAzzan(){
        CartaFactory CAAzzan = new AzzanCardFactory();
        List<Carta> mazoAzzan = new ArrayList<>();

        Habilidad fireball = new AzzanH1();
        Habilidad vampiricTouch = new AzzanH2();
        Habilidad charm = new AzzanH3();

        Carta fireballCard = CAAzzan.createCartaEspecial("Fireball",fireball);
        mazoAzzan.add(fireballCard);
        mazoAzzan.add(fireballCard);

        Carta evilSneer = CAAzzan.createCartaNormal("Evil Sneer",0,1,0,1,0);
        mazoAzzan.add(evilSneer);
        mazoAzzan.add(evilSneer);

        Carta charmCard = CAAzzan.createCartaEspecial("Charm",charm);
        mazoAzzan.add(charmCard);
        mazoAzzan.add(charmCard);

        Carta knowledgeIsPower = CAAzzan.createCartaNormal("Knowledge is Power",0,0,0,0,3);
        mazoAzzan.add(knowledgeIsPower);
        mazoAzzan.add(knowledgeIsPower);
        mazoAzzan.add(knowledgeIsPower);

        Carta shield = CAAzzan.createCartaNormal("Shield",0,0,1,0,1);
        mazoAzzan.add(shield);

        Carta stoneSkin = CAAzzan.createCartaNormal("Stone skin",0,0,2,0,0);
        mazoAzzan.add(stoneSkin);

        Carta mirrorImage = CAAzzan.createCartaNormal("Mirror image", 0,0,3,0,0);
        mazoAzzan.add(mirrorImage);

        Carta vampiricTouchCard = CAAzzan.createCartaEspecial("Vampiric Touch",vampiricTouch);
        mazoAzzan.add(vampiricTouchCard);
        mazoAzzan.add(vampiricTouchCard);

        Carta lightningBolt = CAAzzan.createCartaNormal("Lightning Bolt",3,0,0,0,0);
        mazoAzzan.add(lightningBolt);
        mazoAzzan.add(lightningBolt);
        mazoAzzan.add(lightningBolt);
        mazoAzzan.add(lightningBolt);

        Carta speedOfThought = CAAzzan.createCartaNormal("Speed of Thought",0,0,0,2,0);
        mazoAzzan.add(speedOfThought);
        mazoAzzan.add(speedOfThought);
        mazoAzzan.add(speedOfThought);

        Carta magicMissile = CAAzzan.createCartaNormal("Magic missile", 1,0,0,1,0);
        mazoAzzan.add(magicMissile);
        mazoAzzan.add(magicMissile);
        mazoAzzan.add(magicMissile);

        Carta burningHand = CAAzzan.createCartaNormal("Burning Hand",2,0,0,0,0);
        mazoAzzan.add(burningHand);
        mazoAzzan.add(burningHand);
        mazoAzzan.add(burningHand);

        return mazoAzzan;
    }

    public static List<Carta> generarCartasBlorp(){
        CartaFactory CABlorp = new BlorpCardFactory();
        List<Carta> mazoBlorp = new ArrayList<>();

        Habilidad directHit = new BlorpH1();
        Habilidad shieldDestroyer = new BlorpH2();
        Habilidad counter = new BlorpH3();

        Carta fastestCubeAlive = CABlorp.createCartaNormal("Fastest Cube alive", 1,1,0,0,1);
        mazoBlorp.add(fastestCubeAlive);
        mazoBlorp.add(fastestCubeAlive);
        mazoBlorp.add(fastestCubeAlive);

        Carta arcaneAppetizer = CABlorp.createCartaNormal("Arcane Appetizer",2,0,0,0,1);
        mazoBlorp.add(arcaneAppetizer);
        mazoBlorp.add(arcaneAppetizer);

        Carta formerFriends = CABlorp.createCartaNormal("Former Friends", 0,0,2,0,0);
        mazoBlorp.add(formerFriends);

        Carta sugarRush = CABlorp.createCartaNormal("Sugar Rush",0,0,0,0,2);
        mazoBlorp.add(sugarRush);
        mazoBlorp.add(sugarRush);

        Carta combatCubed = CABlorp.createCartaNormal("Combat Cubed" , 3,0,0,0,0);
        mazoBlorp.add(combatCubed);
        mazoBlorp.add(combatCubed);
        mazoBlorp.add(combatCubed);

        Carta cubesHaveFeelingsToo = CABlorp.createCartaNormal("Cubes Have Feelings too",0,1,0,1,0);
        mazoBlorp.add(cubesHaveFeelingsToo);
        mazoBlorp.add(cubesHaveFeelingsToo);

        Carta acidBurp = CABlorp.createCartaNormal("Acid Burp",1,0,0,1,0);
        mazoBlorp.add(acidBurp);
        mazoBlorp.add(acidBurp);

        Carta hereICome = CABlorp.createCartaEspecial("Here I come", 3,0,0,0,0,directHit);
        mazoBlorp.add(hereICome);
        mazoBlorp.add(hereICome);

        Carta openWide = CABlorp.createCartaNormal("Open Wide" , 0,0,0,1,2);
        mazoBlorp.add(openWide);

        Carta hugs = CABlorp.createCartaEspecial("Hugs", shieldDestroyer);
        mazoBlorp.add(hugs);
        mazoBlorp.add(hugs);

        Carta clericALaSlime = CABlorp.createCartaNormal("Cleric a la Slime",2,1,0,0,0);
        mazoBlorp.add(clericALaSlime);
        mazoBlorp.add(clericALaSlime);

        Carta d6OfDoom = CABlorp.createCartaNormal("D6 of Doom", 2,0,0,0,0);
        mazoBlorp.add(d6OfDoom);
        mazoBlorp.add(d6OfDoom);

        Carta slimeTime = CABlorp.createCartaNormal("Slime time",0,0,0,2,0);
        mazoBlorp.add(slimeTime);
        mazoBlorp.add(slimeTime);

        Carta burpedUpBones = CABlorp.createCartaNormal("Burped of Bones",0,0,3,0,0);
        mazoBlorp.add(burpedUpBones);
        mazoBlorp.add(burpedUpBones);

        return mazoBlorp;
    }

    public static List<Carta> generarCartasDelilah(){
        CartaFactory CADelilah = new DelilahCardFactory();
        List<Carta> mazoDelilah = new ArrayList<>();

        Habilidad praise = new DelilahH1();
        Habilidad publicEnemy = new DelilahH2();
        Habilidad noMercy = new DelilahH3();

        Carta rayForDays = CADelilah.createCartaNormal("Ray for Days",0,0,0,2,0);
        mazoDelilah.add(rayForDays);
        mazoDelilah.add(rayForDays);

        Carta multitask = CADelilah.createCartaNormal("Multitask",2,1,0,0,0);
        mazoDelilah.add(multitask);
        mazoDelilah.add(multitask);

        Carta doubleTrouble = CADelilah.createCartaNormal("Double trouble",2,0,0,0,0);
        mazoDelilah.add(doubleTrouble);
        mazoDelilah.add(doubleTrouble);

        Carta beautyBarrage = CADelilah.createCartaNormal("Beauty Barrage",3,0,0,0,0);
        mazoDelilah.add(beautyBarrage);
        mazoDelilah.add(beautyBarrage);
        mazoDelilah.add(beautyBarrage);

        Carta laserShow = CADelilah.createCartaNormal("Laser Show",1,0,0,1,0);
        mazoDelilah.add(laserShow);
        mazoDelilah.add(laserShow);
        mazoDelilah.add(laserShow);

        Carta praiseMe = CADelilah.createCartaEspecial("Praise me",0,0,0,0,3,praise);
        mazoDelilah.add(praiseMe);
        mazoDelilah.add(praiseMe);

        Carta fashionPolice = CADelilah.createCartaNormal("Fashion Police",0,0,3,0,0);
        mazoDelilah.add(fashionPolice);
        mazoDelilah.add(fashionPolice);

        Carta mirrorMirror = CADelilah.createCartaNormal("Mirror mirror",0,0,2,0,0);
        mazoDelilah.add(mirrorMirror);
        mazoDelilah.add(mirrorMirror);

        Carta makeItWork = CADelilah.createCartaNormal("Make it work" , 0,2,0,0,1);
        mazoDelilah.add(makeItWork);
        mazoDelilah.add(makeItWork);

        Carta meMyselfAndI = CADelilah.createCartaNormal("Me, Myself and I",0,1,0,0,1);
        mazoDelilah.add(meMyselfAndI);

        Carta cutterThanYou = CADelilah.createCartaNormal("Cutter than you",0,0,0,0,2);
        mazoDelilah.add(cutterThanYou);

        Carta tyrannyOfBeauty = CADelilah.createCartaNormal("Tyranny of Beauty",1,1,0,1,0);
        mazoDelilah.add(tyrannyOfBeauty);

        Carta charmRay = CADelilah.createCartaEspecial("Charm ray",publicEnemy);
        mazoDelilah.add(charmRay);
        mazoDelilah.add(charmRay);

        Carta deathRay = CADelilah.createCartaEspecial("Death Ray",noMercy);
        mazoDelilah.add(deathRay);
        mazoDelilah.add(deathRay);
        mazoDelilah.add(deathRay);

        return mazoDelilah;
    }

    public static List<Carta> generarCartasLia(){
        List<Carta> mazoLia = new ArrayList<>();
        CartaFactory CALia = new LiaCardFactory();

        Habilidad destroy = new LiaH1();
        Habilidad picky = new LiaH2();

        Carta forJustice = CALia.createCartaNormal("For Justice",1,0,0,1,0);
        mazoLia.add(forJustice);
        mazoLia.add(forJustice);
        mazoLia.add(forJustice);

        Carta forTheMostJustice = CALia.createCartaNormal("For the most Justice",3,0,0,0,0);
        mazoLia.add(forTheMostJustice);
        mazoLia.add(forTheMostJustice);

        Carta forEvenMoreJustice = CALia.createCartaNormal("For even more Justice",2,0,0,0,0);
        mazoLia.add(forEvenMoreJustice);
        mazoLia.add(forEvenMoreJustice);
        mazoLia.add(forEvenMoreJustice);
        mazoLia.add(forEvenMoreJustice);

        Carta fightingSwords = CALia.createCartaNormal("Fighting Swords",2,1,0,0,0);
        mazoLia.add(fightingSwords);
        mazoLia.add(fightingSwords);
        mazoLia.add(fightingSwords);

        Carta divineSmith = CALia.createCartaNormal("Divine Smith",3,1,0,0,0);
        mazoLia.add(divineSmith);
        mazoLia.add(divineSmith);
        mazoLia.add(divineSmith);

        Carta cureWounds = CALia.createCartaNormal("Cure wounds",0,1,0,0,2);
        mazoLia.add(cureWounds);

        Carta divineShield = CALia.createCartaNormal("Divine Shield",0,0,3,0,0);
        mazoLia.add(divineShield);
        mazoLia.add(divineShield);

        Carta fluffy = CALia.createCartaNormal("Fluffy",0,0,2,0,0);
        mazoLia.add(fluffy);

        Carta spinnigParry = CALia.createCartaNormal("Spinning parry",0,0,1,0,1);
        mazoLia.add(spinnigParry);
        mazoLia.add(spinnigParry);

        Carta banishingSmite = CALia.createCartaEspecial("Banishing Smite",0,0,0,1,0,destroy);
        mazoLia.add(banishingSmite);

        Carta divineInspiration = CALia.createCartaEspecial("Divine Inspiration",0,2,0,0,0,picky);
        mazoLia.add(divineInspiration);
        mazoLia.add(divineInspiration);

        Carta fingerWagOfJudgmente = CALia.createCartaNormal("Finger wag of Judgmente",0,0,0,2,0);
        mazoLia.add(fingerWagOfJudgmente);
        mazoLia.add(fingerWagOfJudgmente);

        Carta highCharisma = CALia.createCartaNormal("High Charisma",0,0,0,0,2);
        mazoLia.add(highCharisma);
        mazoLia.add(highCharisma);

        return mazoLia;
    }

    public static List<Carta> generarCartasMinscAndBoo(){
        List<Carta> mazoMinsc = new ArrayList<>();
        CartaFactory CAMinsc = new MinscAndBooFactory();

        Habilidad drawer = new MinscH1();
        Habilidad rotation = new MinscH2();
        Habilidad bonusattack = new MinscH3();

        Carta krydleAndShandie = CAMinsc.createCartaNormal("Krydle and Shandle",0,0,3,0,0);
        mazoMinsc.add(krydleAndShandie);

        Carta timeToPunchEvil = CAMinsc.createCartaNormal("Time to Punch Evil",2,0,0,1,0);
        mazoMinsc.add(timeToPunchEvil);

        Carta squaryWheelGetsTheKick = CAMinsc.createCartaNormal("Squary Wheel gets the Kick",1,0,0,1,0);
        mazoMinsc.add(squaryWheelGetsTheKick);
        mazoMinsc.add(squaryWheelGetsTheKick);
        mazoMinsc.add(squaryWheelGetsTheKick);

        Carta justiceWaitForNoOne = CAMinsc.createCartaNormal("Justice Wait for no one",0,0,0,2,0);
        mazoMinsc.add(justiceWaitForNoOne);
        mazoMinsc.add(justiceWaitForNoOne);

        Carta someoneHoldMtRodent = CAMinsc.createCartaNormal("Someone hold Mt. Rodent",2,1,0,0,0);
        mazoMinsc.add(someoneHoldMtRodent);
        mazoMinsc.add(someoneHoldMtRodent);

        Carta scoutingOutling = CAMinsc.createCartaEspecial("Scouting Outling",drawer);
        mazoMinsc.add(scoutingOutling);
        mazoMinsc.add(scoutingOutling);

        Carta palePriestessNerys = CAMinsc.createCartaNormal("Pale priestess Nerys",0,1,1,0,0);
        mazoMinsc.add(palePriestessNerys);
        mazoMinsc.add(palePriestessNerys);

        Carta booWhatDoWeDo = CAMinsc.createCartaNormal("Boo, what do we do?",0,0,0,0,2);
        mazoMinsc.add(booWhatDoWeDo);
        mazoMinsc.add(booWhatDoWeDo);

        Carta wrapItUp = CAMinsc.createCartaNormal("Wrap it up",0,1,0,0,1);
        mazoMinsc.add(wrapItUp);

        Carta swapportunity = CAMinsc.createCartaEspecial("Swapportunity",rotation);
        mazoMinsc.add(swapportunity);
        mazoMinsc.add(swapportunity);

        Carta minscsMightyMount = CAMinsc.createCartaNormal("Minsc mighty Mount",0,0,2,0,0);
        mazoMinsc.add(minscsMightyMount);
        mazoMinsc.add(minscsMightyMount);

        Carta goForTheEyes = CAMinsc.createCartaNormal("Go for the Eyes",3,0,0,0,0);
        mazoMinsc.add(goForTheEyes);
        mazoMinsc.add(goForTheEyes);
        mazoMinsc.add(goForTheEyes);

        Carta twiceTheSmitting = CAMinsc.createCartaNormal("Twice the Smitting",2,0,0,0,0);
        mazoMinsc.add(twiceTheSmitting);
        mazoMinsc.add(twiceTheSmitting);
        mazoMinsc.add(twiceTheSmitting);

        Carta favoredFrienemies = CAMinsc.createCartaEspecial("Favored Frienemiies",bonusattack);
        mazoMinsc.add(favoredFrienemies);
        mazoMinsc.add(favoredFrienemies);

        return mazoMinsc;
    }

    public static List<Carta> generarCartasSutha(){
        List<Carta> mazoSutha = new ArrayList<>();
        CartaFactory CASutha = new SuthaCardFactory();

        Habilidad shieldBreaker = new SuthaH1();
        Habilidad discard = new SuthaH2();
        Habilidad backstab = new SuthaH3();

        Carta openTheArmory = CASutha.createCartaNormal("Open the Armory",0,0,0,0,2);
        mazoSutha.add(openTheArmory);
        mazoSutha.add(openTheArmory);

        Carta flex = CASutha.createCartaNormal("Flex",0,1,0,0,1);
        mazoSutha.add(flex);
        mazoSutha.add(flex);

        Carta snackTime = CASutha.createCartaNormal("Snack time",0,1,0,0,2);
        mazoSutha.add(snackTime);

        Carta twoAxesAreBetterThanOne = CASutha.createCartaNormal("Two axes are better than one",0,0,0,2,0);
        mazoSutha.add(twoAxesAreBetterThanOne);
        mazoSutha.add(twoAxesAreBetterThanOne);

        Carta brutalPunch = CASutha.createCartaNormal("Brutal punch",2,0,0,0,0);
        mazoSutha.add(brutalPunch);
        mazoSutha.add(brutalPunch);

        Carta bigAxeIsBestAxe = CASutha.createCartaNormal("Big Axe is best Axe",3,0,0,0,0);
        mazoSutha.add(bigAxeIsBestAxe);
        mazoSutha.add(bigAxeIsBestAxe);
        mazoSutha.add(bigAxeIsBestAxe);
        mazoSutha.add(bigAxeIsBestAxe);
        mazoSutha.add(bigAxeIsBestAxe);

        Carta rage = CASutha.createCartaNormal("RAGE!",4,0,0,0,0);
        mazoSutha.add(rage);
        mazoSutha.add(rage);

        Carta raff = CASutha.createCartaNormal("Raff",0,0,3,0,0);
        mazoSutha.add(raff);
        mazoSutha.add(raff);

        Carta headButt = CASutha.createCartaNormal("Headbutt",1,0,0,1,0);
        mazoSutha.add(headButt);
        mazoSutha.add(headButt);

        Carta spikedShield = CASutha.createCartaNormal("Spiked Shield",0,0,2,0,0);
        mazoSutha.add(spikedShield);

        Carta bagOfRats = CASutha.createCartaNormal("Bag of Rats",0,0,1,0,1);
        mazoSutha.add(bagOfRats);

        Carta mightyToss = CASutha.createCartaEspecial("Mighty toss",0,0,0,0,1,shieldBreaker);
        mazoSutha.add(mightyToss);
        mazoSutha.add(mightyToss);

        Carta battleRoar = CASutha.createCartaEspecial("Battle Roar",discard);
        mazoSutha.add(battleRoar);
        mazoSutha.add(battleRoar);

        Carta whirlingAxe = CASutha.createCartaEspecial("Whirling Axe",backstab);
        mazoSutha.add(whirlingAxe);
        mazoSutha.add(whirlingAxe);


        return mazoSutha;
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(List<Carta> mazo) {
        this.mazo = mazo;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }
}
