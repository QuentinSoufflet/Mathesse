//   __       __   ______  ________  __    __  ________   ______    ______   ________
//  |  \     /  \ /      \|        \|  \  |  \|        \ /      \  /      \ |        \
//  | $$\   /  $$|  $$$$$$\\$$$$$$$$| $$  | $$| $$$$$$$$|  $$$$$$\|  $$$$$$\| $$$$$$$$
//  | $$$\ /  $$$| $$__| $$  | $$   | $$__| $$| $$__    | $$___\$$| $$___\$$| $$__
//  | $$$$\  $$$$| $$    $$  | $$   | $$    $$| $$  \    \$$    \  \$$    \ | $$  \
//  | $$\$$ $$ $$| $$$$$$$$  | $$   | $$$$$$$$| $$$$$    _\$$$$$$\ _\$$$$$$\| $$$$$
//  | $$ \$$$| $$| $$  | $$  | $$   | $$  | $$| $$_____ |  \__| $$|  \__| $$| $$_____
//  | $$  \$ | $$| $$  | $$  | $$   | $$  | $$| $$     \ \$$    $$ \$$    $$| $$     \
//   \$$      \$$ \$$   \$$   \$$    \$$   \$$ \$$$$$$$$  \$$$$$$   \$$$$$$  \$$$$$$$$
import extensions.CSVFile;
class Mathesse extends Program
{
    Position positionJoueur = new Position();
    final Difficulte difficulte = new Difficulte();
    Joueur joueur = new Joueur();
    Resultat resultat = new Resultat();
    CaractereDigital caractereDigital = new CaractereDigital();
    String[][] plateau;
    String[][] tableauResultat = new String[3][5];
    boolean gameOver = false;
    boolean partieFini = false;

    final char LANCERJ = 'J';
    final char LANCERj = 'j';
    final char QUITTERS = 'S';
    final char QUITTERs = 's';
//  void affichagePosition | Affiche graphiquement la position du joueur sur le plateau.
    void affichagePosition(int positionActuelle)
    {
        if(positionActuelle == 0)
        {
            for (int i = 0; i < length(positionJoueur.tabPosition1, 1); i = i + 1)
            {
                for (int j = 0; j < length(positionJoueur.tabPosition1, 2); j = j + 1)
                {
                    print(positionJoueur.tabPosition1[i][j]);
                }
                println();
            }
        }
        if(positionActuelle == 1)
        {
            for (int i = 0; i < length(positionJoueur.tabPosition2, 1); i = i + 1)
            {
                for (int j = 0; j < length(positionJoueur.tabPosition2, 2); j = j + 1)
                {
                    print(positionJoueur.tabPosition2[i][j]);
                }
                println();
            }
        }
        if(positionActuelle == 2)
        {
            for (int i = 0; i < length(positionJoueur.tabPosition3, 1); i = i + 1)
            {
                for (int j = 0; j < length(positionJoueur.tabPosition3, 2); j = j + 1)
                {
                    print(positionJoueur.tabPosition3[i][j]);
                }   
                println();
            }
        }
        if(positionActuelle == 3)
        {
            for (int i = 0; i < length(positionJoueur.tabPosition4, 1); i = i + 1)
            {
                for (int j = 0; j < length(positionJoueur.tabPosition4, 2); j = j + 1)
                {
                    print(positionJoueur.tabPosition4[i][j]);
                }
                println();
            }
        }
        if(positionActuelle == 4)
        {
            for (int i = 0; i < length(positionJoueur.tabPosition5, 1); i = i + 1)
            {
                for (int j = 0; j < length(positionJoueur.tabPosition5, 2); j = j + 1)
                {
                    print(positionJoueur.tabPosition5[i][j]);
                }  
                println();
            }
        }
    }
//  void tableauCalcul | représente le calcul en format digital.
    void tableauCalcul(int i, int j)
    {
        String chaineCalcul = plateau[i][j];
        char[][] calcul = new char[(5)][(7*length(chaineCalcul))];

        int indice = 0;
        int decalage = 0;
        while(indice < length(chaineCalcul))
        {
            for(int y = 0; y < length(calcul, 1); y++)
            {
                if(charAt(chaineCalcul, indice) >= '0' && charAt(chaineCalcul, indice) <= '9')
                {
                    if(charAt(chaineCalcul, indice) == '0')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.zero[y][x];
                            
                        }
                    }if(charAt(chaineCalcul, indice) == '1')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.un[y][x];
                            
                        }
                    }
                    if(charAt(chaineCalcul, indice) == '2')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.deux[y][x];
                            
                        }
                    }
                    if(charAt(chaineCalcul, indice) == '3')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.trois[y][x];
                            
                        }
                    }
                    if(charAt(chaineCalcul, indice) == '4')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.quatre[y][x];
                            
                        }
                    }
                    if(charAt(chaineCalcul, indice) == '5')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.cinq[y][x];
                            
                        }
                    }
                    if(charAt(chaineCalcul, indice) == '6')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.six[y][x];
                            
                        }
                    }
                    if(charAt(chaineCalcul, indice) == '7')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.sept[y][x];
                            
                        }
                    }
                    if(charAt(chaineCalcul, indice) == '8')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.huit[y][x];
                            
                        }
                    }
                    if(charAt(chaineCalcul, indice) == '9')
                    {
                        for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                        {
                            calcul[y][x + decalage] = caractereDigital.neuf[y][x];
                            
                        }
                    }
                }else if(charAt(chaineCalcul, indice) == '+')
                {
                    for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                    {
                        calcul[y][x + decalage] = caractereDigital.plus[y][x];
                    } 
                }else if(charAt(chaineCalcul, indice) == '=')
                {
                    for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                    {
                        calcul[y][x + decalage] = caractereDigital.egal[y][x];
                    }
                }else if(charAt(chaineCalcul, indice) == '-')
                {
                    for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                    {
                        calcul[y][x + decalage] = caractereDigital.moins[y][x];
                    }
                }else if(charAt(chaineCalcul, indice) == 'x')
                {
                    for(int x = 0; x < length(caractereDigital.vide, 2); x++)
                    {
                        calcul[y][x + decalage] = caractereDigital.croix[y][x];
                    }
                }
            }
            decalage = decalage + 7;
            indice++;
        }
        int longueurTableau = length(chaineCalcul) * 7;
        int longeurTableauAffichage = 87 - longueurTableau;
        int longueurRestante1 = longeurTableauAffichage / 2;
        print("+");
        for(int h = 0; h < (length(chaineCalcul) * 7); h++)
        {
            print("-");
        }
        for(int h = 0; h < (87 - (length(chaineCalcul) * 7)); h++)
        {
            print("-");
        }
        print("+");
        println();
        for(int y = 0; y < length(calcul, 1); y++)
        {
            int longueurRestante2 = longueurRestante1;
            print("|");
            for(int x = 0; x < longueurRestante1; x++)
            {
                print(" ");
            }
            for(int x = 0; x < length(calcul, 2); x++)
            {
                print(calcul[y][x]);
            }
            if(length(chaineCalcul) == 4)
            {
                longueurRestante2 = longueurRestante1 + 1;
            }
            for(int x = 0; x < longueurRestante2; x++)
            {
                print(" ");
            }
            print("|");
            println();
        }
        print("+");
        for(int h = 0; h < (length(chaineCalcul) * 7); h++)
        {
            print("-");
        }
        for(int h = 0; h < (87 - (length(chaineCalcul) * 7)); h++)
        {
            print("-");
        }
        print("+");
        println();
    }
//  int entierRandom | génère les termes nécessaire à la création du calcul.
    int entierRandom(char choixMenu, int difficulte)
    {
        double alea = random();
        int nbr = (int)(alea * difficulte);
        return nbr;
    }
//  int resolutionCalcul | créé la solution du calcul.
    int resolutionCalcul(int A, int B, char symbol)
    {
        int reponse = 0;
        if(symbol == '+')
        {
            reponse = A + B;
        }
        else if(symbol == '-')
        {
            if(B > A)
            {
                reponse = B - A;
            }
            else
            {
                reponse = A - B;
            }
        }
        else if(symbol == 'x')
        {
            reponse = A * B;
        }
        return reponse;
    }

    void testResolutionCalcul(){
        assertEquals(30, resolutionCalcul(15, 15, '+'));
        assertEquals(50, resolutionCalcul(20, 30, '+'));

        assertEquals(10, resolutionCalcul(70, 60, '-'));
        assertEquals(5, resolutionCalcul(5, 10, '-'));

        assertEquals(42, resolutionCalcul(6, 7, 'x'));
        assertEquals(0, resolutionCalcul(0, 9, 'x'));
    }
//  String calcul | transforme le calcul en chaîne de caractère pouvant être afficher à l'écran.
    String calcul(int A, int B, char symbol)
    {
        String reponse = " ";
        if(symbol == '+')
        {
            reponse = "" + A + symbol + B;
        }
        else if(symbol == '-')
        {
            if(B > A)
            {
                reponse = "" + B + symbol + A;
            }
            else
            {
                reponse = "" + A + symbol + B;
            }
        }
        else if(symbol == 'x')
        {
            reponse = "" + A + symbol + B;
        }
        return reponse; 
    }

    void testCalcul(){
        assertEquals("30+18", calcul(30, 18, '+'));
        assertEquals("10-4", calcul(10, 4, '-'));
        assertEquals("10-4", calcul(4, 10, '-'));
        assertEquals("9x9", calcul(9, 9, 'x'));
    }
//  boolean reponseVraie | verifie si la reponse qui est rentrée par l'utilisateur est bonne ou non.
    boolean reponseVraie(String[][] plateau, int icolonnes, int ilignes, String saisieReponse)
    {
        boolean verif = false;
        String calcul = plateau[icolonnes][ilignes];
        int termeA, termeB, reponse;
        char symbol;
        for(int i = 0; i < length(calcul); i++)
        {
            if(charAt(calcul, i) == '+')
            {
                symbol = charAt(calcul, i);
                termeA = stringToInt(substring(calcul, 0, i));
                termeB = stringToInt(substring(calcul, (i+1), length(calcul)));
                reponse = resolutionCalcul(termeA, termeB, symbol);
                if(stringToInt(saisieReponse) == reponse)
                {
                    verif = true;
                }else
                {
                    verif = false;
                }
            }
            if(charAt(calcul, i) == '-')
            {
                symbol = charAt(calcul, i);
                termeA = stringToInt(substring(calcul, 0, i));
                termeB = stringToInt(substring(calcul, (i+1), length(calcul)));
                reponse = resolutionCalcul(termeA, termeB, symbol);
                if(stringToInt(saisieReponse) == reponse)
                {
                    verif = true;
                }else
                {
                    verif = false;
                }
            }
            if(charAt(calcul, i) == 'x')
            {
                symbol = charAt(calcul, i);
                termeA = stringToInt(substring(calcul, 0, i));
                termeB = stringToInt(substring(calcul, (i+1), length(calcul)));
                reponse = resolutionCalcul(termeA, termeB, symbol);
                if(stringToInt(saisieReponse) == reponse)
                {
                    verif = true;
                }else
                {
                    verif = false;
                }
            }
        }
        return verif;
    }

    void testReponseVraie(){
        String[][] tabTest = new String[][]{{"10+86","0+0","0+0"},
                                            {"20-18","0-0","0-0"},
                                            {"8x3","0x0","0x0"}};
        assertTrue(reponseVraie(tabTest, 0, 0, "96"));
        assertTrue(reponseVraie(tabTest, 1, 0, "2"));
        assertTrue(reponseVraie(tabTest, 2, 0, "24"));
    }
//  boolean verificationSaisie | verifie si la saisie de l'utilisateur est valide ou non.
    boolean verificationSaisie(String saisieReponse)
    {
        boolean verif = false;
        int compteur = 0;
        if(length(saisieReponse) > 0)
        {        
            if(saisieReponse == "SORTIR"){
                verif = true;
            }
            for(int i = 0; i < length(saisieReponse); i++)
            {
                if(charAt(saisieReponse, i) >= '0' && charAt(saisieReponse, i) <= '9')
                {
                    compteur++;
                }
            }
        }
        if(compteur == length(saisieReponse))
        {
            verif = true;
        }
        return verif;
    }

    void testVerificationSaisie(){
        assertTrue(verificationSaisie("SORTIR"));
        assertTrue(verificationSaisie("6545"));
        assertFalse(verificationSaisie("BUT"));
        assertFalse(verificationSaisie("INFORMATIQUE"));
        assertFalse(verificationSaisie("-50"));
        assertFalse(verificationSaisie("10,56"));
    }
//  String[] initPlateau | initialise un plateau 2D ayant pour dimension 3 lignes et 5 colonnes.
    String[][] initPlateau()
    {
        String[][] plateau = new String[3][5];
        plateauRempli(plateau);
        return plateau;
    }
//  String[][] plateauRempli | rempli le plateau avec les calculs associé à chaque lignes (ligne 1 = addiditon, ligne 2 = soustraction, ligne 3 = multiplication).
    String[][] plateauRempli(String[][] plateau)
    {
        char symbol;
        int A, B;
        for(int i = 0; i < length(plateau, 1); i++)
        {
            for(int j = 0; j < length(plateau, 2); j++)
            {
                if(i == 0)
                {
                    symbol = '+';
                    A = entierRandom(symbol, difficulte.difficile);
                    B = entierRandom(symbol, difficulte.difficile);
                    plateau[0][j] = calcul(A, B, symbol);
                }else if(i == 1)
                {
                    symbol = '-';
                    A = entierRandom(symbol, difficulte.moyen);
                    B = entierRandom(symbol, difficulte.moyen);
                    plateau[1][j] = calcul(A, B, symbol);
                }else
                {
                    symbol = 'x';
                    A = entierRandom(symbol, difficulte.normal);
                    B = entierRandom(symbol, difficulte.normal);
                    plateau[2][j] = calcul(A, B, symbol);
                }
            }
        }
        return plateau;
    }
//  String combatBossTxt | affiche , lorsque l'utilisateur est arrivé à la dernière case de la ligne, sous forme de texte quel est le boss présent à la 5ème case de la ligne.
    void combatBossTxt(int compteur)
    {
        String txt = "";
        if(compteur == 5)
        {
            println("+---------------------------------------------------------------------------------------+");
            println("|Rencontre avec un Inconnu !                                                            |");
            println("|Tu affrontes le chevalier des additions, X !                                           |");
            println("+---------------------------------------------------------------------------------------+");
        }else if(compteur == 10)
        {
            println("+---------------------------------------------------------------------------------------+");
            println("|Rencontre avec un Inconnu !                                                            |");
            println("|Tu affrontes l'archer des soustractions, Y !                                           |");
            println("+---------------------------------------------------------------------------------------+");
        }else if(compteur == 15)
        {
            println("+---------------------------------------------------------------------------------------+");
            println("|Rencontre avec un Inconnu !                                                            |");
            println("|Tu affrontes le sorcier des multiplications, Z !                                        |");
            println("+---------------------------------------------------------------------------------------+");
        }
    }
//  void creationJoueur | créé le profil de l'utilisateur.
    void creationJoueur()
    {
        println("+---------------------------------------------------------------------------------------+");
        println("|Peux-tu me dire quel est ton prénom ?                                                  |");
        println("+---------------------------------------------------------------------------------------+");
        joueur.pseudo = readString();
    }
//  void jouerPartie | lance le joueur sur le plateau.
    void jouerPartie()
    {
        int compteur = 0;
        int i = 0;
        while(i < length(plateau, 1) && !gameOver)
        {
            int j = 0;
            while(j < length(plateau, 2) && !gameOver)
            {
                affichagePosition(j);
                compteur++;
                if(j == (length(plateau, 2) - 1))
                {
                    combatBossTxt(compteur);
                }else
                {
                    if(compteur > 9)
                    {
                        println("+---------------------------------------------------------------------------------------+");
                        println("|Question n°" + compteur + "                                                                          |");
                        println("+---------------------------------------------------------------------------------------+");
                    }else{
                        println("+---------------------------------------------------------------------------------------+");
                        println("|Question n°" + compteur + "                                                                           |");
                        println("+---------------------------------------------------------------------------------------+");
                    }
                }
                if(joueur.score > 9)
                {
                    println("+---------------------------------------------------------------------------------------+");
                    println("|Score : " + joueur.score + "                                                                             |");
                    println("+---------------------------------------------------------------------------------------+");
                }else
                {
                    println("+---------------------------------------------------------------------------------------+");
                    println("|Score : " + joueur.score + "                                                                              |");
                    println("+---------------------------------------------------------------------------------------+");
                }
                if(joueur.vie > 9)
                {
                    println("+---------------------------------------------------------------------------------------+");
                    println("|Vie : " + joueur.vie + "                                                                             |");
                    println("+---------------------------------------------------------------------------------------+");
                }else
                {
                    println("+---------------------------------------------------------------------------------------+");
                    println("|Vie : " + joueur.vie + "                                                                                |");
                    println("+---------------------------------------------------------------------------------------+");
                }
                tableauCalcul(i, j);
                saisieDeLaReponse(i, j);
                j = j + 1;
            }
            i = i + 1;
        }
    }
//  void affichageGainScore | affiche un texte permettant de visualiser le gain de point.
    void affichageGainScore(){
        println("+---------------------------------------------------------------------------------------+");
        println("|+1 point !                                                                             |");
        if(joueur.score > 9)
        {
            println("|Score actuel : " + joueur.score + "                                                                      |");  
        }else
        {
            println("|Score actuel : " + joueur.score + "                                                                       |"); 
        }
        println("+---------------------------------------------------------------------------------------+");
    }
//  void affichagePerteVie | affiche un texte permettant de visualiser la perte de vie.
    void affichagePerteVie(){
        println("+---------------------------------------------------------------------------------------+");
        println("|-1 vie !                                                                               |");
        println("|Vie actuel : " + joueur.vie + "                                                                         |");
        println("+---------------------------------------------------------------------------------------+");
    }

//  void saisieDeLaReponse | permet à l'utilisateur de rentrer sa réponse pour le calcul qui lui est propposé.
    void saisieDeLaReponse(int i, int j)
    {
        boolean bonneReponse = false;
        boolean aJoue = false;
        boolean quitter = false;
        String saisieReponse;
        do
        {   
            saisieReponse = readString();
            println();
            if(length(saisieReponse) > 0)
            {                       
                if(verificationSaisie(saisieReponse) == true)
                {   
                    bonneReponse = reponseVraie(plateau, i, j, saisieReponse);
                    if(bonneReponse == true)
                    {
                        joueur.score = joueur.score + 1;
                        tableauResultat[i][j] = resultat.bon;
                        affichageGainScore();
                        aJoue = true;
                        if(joueur.score == 15)
                        {
                            partieFini = true;
                        }
                    }else if(bonneReponse == false)
                    {
                        joueur.vie = joueur.vie - 1;
                        tableauResultat[i][j] = resultat.mauvais;
                        affichagePerteVie();
                        aJoue = true;
                        if(joueur.vie <= 0)
                        {
                            gameOver = true;
                        }
                    }
                }else
                {
                    println("+---------------------------------------------------------------------------------------+");
                    println("|Saisis un nombre positif (et sans caractère(s) non-numérique) ou SORTIR pour quitter ! |");
                    println("+---------------------------------------------------------------------------------------+");
                }
            }else
            {
                println("+---------------------------------------------------------------------------------------+");
                println("|Saisis une saisie valide !                                                             |");
                println("+---------------------------------------------------------------------------------------+");
            }
        }while(!aJoue && !gameOver && !partieFini);
    }
//  void creationFichierCalcul | créé un fichier qui contient les calculs qui sont générés pour le plateau.
    void creationFichierCalcul()
    {
        final String FILENAMEC = "calcul_" + joueur.pseudo;
        saveCSV(plateau, FILENAMEC);
    }
//  void creationFichierResultat | créé un fichier qui contient les réussites ou les échecs de l'utilisateur.
    void creationFichierResultat()
    {
        final String FILENAMER = "resultat_" + joueur.pseudo;
        saveCSV(tableauResultat, FILENAMER);
    }
//  void algorithm | est le corps principal du programme.
    void algorithm()
    {   
        clearScreen();
        println("+---------------------------------------------------------------------------------------+");
        println("|Bienvenue dans Mathesse !                                                              |");
        println("|Ta mission : sauver la princesse qui est retenue prisonnière dans la cave des Inconnus.|");
        println("|Pour cela, tu devras résoudre des problèmes mathématiques tels que :                   |");
        println("|- des additions                                                                        |");
        println("|- des soustractions                                                                    |");
        println("|- des multiplications                                                                  |");
        println("|Sur ton chemin, tu rencontreras les Inconnus, ils sont au nombre de 3 :                |");
        println("|- X, le chevalier des additions                                                        |");
        println("|- Y, l'archer des soustractions                                                        |");
        println("|- Z, le sorcier des multiplications                                                    |");
        println("|                                                                                       |");
        println("|Attention :                                                                            |");
        println("|Tu ne disposes que de 3 vies !                                                         |");
        println("|                                                                                       |");
        char choix;
        boolean soucisSaisie;
        do
        {
            plateau = initPlateau();
            println("|Sélectionne ce que tu veux faire :                                                     |");
            println("|J/ Jouer                                                                               |");
            println("|S/ Sortir                                                                              |");
            println("+---------------------------------------------------------------------------------------+");
            choix = readChar();
            soucisSaisie = false;
            if(choix == LANCERJ || choix == LANCERj)
            {   
                creationJoueur();
                creationFichierCalcul();
                jouerPartie();
                creationFichierResultat();
            }else if(choix == QUITTERS || choix == QUITTERs){
                partieFini = true;
            }else{
                soucisSaisie = true;
                println("+---------------------------------------------------------------------------------------+");
                println("|Choisis entre J (ou j) et S (ou s)                                                     |");
                println("+---------------------------------------------------------------------------------------+");
            }
            if(joueur.score < 15){
                gameOver = true;
            }
        }while(soucisSaisie == true || (!gameOver && !partieFini));

        if(choix != QUITTERS && choix != QUITTERs)
        {
            if(gameOver == true)
            {
                println("+---------------------------------------------------------------------------------------+");
                println("|Tu as perdu !                                                                          |");
                println("|Pour faire une nouvelle tentative, relance le jeu !                                    |");
                println("+---------------------------------------------------------------------------------------+");
            }else if(choix == LANCERJ && choix == LANCERj)
            {
                println("+---------------------------------------------------------------------------------------+");
                println("|Bien joué !                                                                            |");
                println("|Tu as sauvé la princesse !                                                             |");
                println("+---------------------------------------------------------------------------------------+");
            }
        }
    }
}
