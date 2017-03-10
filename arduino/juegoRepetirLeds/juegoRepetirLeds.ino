/*
 * Título: juegoRepetirLeds
 * Autor: Jesús Cruz ( jesus-cruz @github )
 * 
 * Explicación: el juego consiste en estar atento a un ciclo de 4 leds y reptirlo con unos botones
 * Después de que se ejecute la secuencia de leds habrá que introducir la correcta, si no dejará intentarlo indefinidamente
 */

// Los pines donde están conectados los leds
int posLeds[4]={8,9,10,11};

// Los pines donde están conectados los botones
int posButtons[4] ={2,3,4,5};

// El orden en el que se encenderán los pines
int cicloLeds[4] = {8,9,10,11};


void setup() {
    pinMode(posLeds[0], OUTPUT);
    pinMode(posLeds[1], OUTPUT);
    pinMode(posLeds[2], OUTPUT);
    pinMode(posLeds[3], OUTPUT);

    pinMode(posButtons[0], INPUT);
    pinMode(posButtons[1], INPUT);
    pinMode(posButtons[2], INPUT);
    pinMode(posButtons[3], INPUT);
  
}

void loop() {
    calcularCicloRandom();
    ejecutarCicloLed();
    comprobarEntrada();
    delay(1000);
}

// Calculamos el contenido de un array de cuatro posiciones con valores entre 8 y 11 ( los pines )
void calcularCicloRandom(){
    for ( int i = 0; i < 4; i++ ) {
        cicloLeds[i] = random(8,12);
    }
}

// Ejecutamos el ciclo calculado anteriormente
void ejecutarCicloLed(){
    for ( int i = 0; i < 4; i++ ){
        delay(500);
        digitalWrite(cicloLeds[i], HIGH);
        delay(500);
        digitalWrite(cicloLeds[i], LOW);
    }
}

// Ha habido un fallo, encendemos el led rojo
void indicarFallo(){
    digitalWrite(9,HIGH);
    delay(500);
    digitalWrite(9,LOW);
    delay(500);
}

// Vamos comprobando la entrada del usuario, no saldremos hasta que sea la correcta
void comprobarEntrada(){
    for ( int i = 0; i < 4; i++) {
        while ( digitalRead(posButtons[ cicloLeds[i] - 8 ]) == LOW){    // Si no es el correcto...
            delay(10);
        }
        // Notificamos que el led encendido es el correcto
        digitalWrite( cicloLeds[i], HIGH);
        delay(200);
        digitalWrite( cicloLeds[i], LOW);
        delay(200);
    }
    ejecutarCicloExito();
}

// Una animación con leds para indicar el éxito
void ejecutarCicloExito(){
    for ( int i = 0; i < 8; i++ ){
        delay(50);
        digitalWrite(posLeds[i%4], HIGH);
        delay(50);
        digitalWrite(posLeds[i%4], LOW);
    }
}



