CREATE TABLE  HIGHSCORES
   (HIGHSCORE_ID INT PRIMARY KEY,
    PLAYER_NAME VARCHAR(30) NOT NULL,
    SCORE DOUBLE NOT NULL
    );
    
INSERT INTO highscores (highscore_id, player_name,score)
Values(1,'AAA',1000);
INSERT INTO highscores (highscore_id, player_name,score)
Values(2,'BBB',500);
INSERT INTO highscores (highscore_id, player_name,score)
Values(3,'CCC',250);
INSERT INTO highscores (highscore_id, player_name,score)
Values(4,'DDD',100);
INSERT INTO highscores (highscore_id, player_name,score)
Values(5,'EEE',50);