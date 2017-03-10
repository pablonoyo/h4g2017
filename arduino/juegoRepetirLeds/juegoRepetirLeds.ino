int posLeds[4]={8,9,10,11};

int posButtons[4] ={2,3,4,5};

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

// the loop function runs over and over again forever
void loop() {
    calcularCicloRandom();
    ejecutarCicloLed();
    comprobarEntrada();
    delay(1000);
}


void calcularCicloRandom(){
    for ( int i = 0; i < 4; i++ ) {
        cicloLeds[i] = random(8,12);
    }
}

void ejecutarCicloLed(){
    for ( int i = 0; i < 4; i++ ){
        delay(500);
        digitalWrite(cicloLeds[i], HIGH);
        delay(500);
        digitalWrite(cicloLeds[i], LOW);
    }
}

void indicarFallo(){
    digitalWrite(9,HIGH);
    delay(500);
    digitalWrite(9,LOW);
    delay(500);
}



void comprobarEntrada(){
    for ( int i = 0; i < 4; i++) {
        while ( digitalRead(posButtons[ cicloLeds[i] - 8 ]) == LOW){
            delay(10);
        }
        digitalWrite( cicloLeds[i], HIGH);
        delay(200);
        digitalWrite( cicloLeds[i], LOW);
        delay(200);
    }
}



