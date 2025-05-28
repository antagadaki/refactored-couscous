public class User {
    private String username;
    private String password;
    private int score;
    // Constructors, getters, setters
}
import java.sql.*;
import java.util.*;

public class DatabaseManager {
    private Connection conn;

    public DatabaseManager(String dbURL, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, user, password);
    }

    public boolean login(String username, String password) {
        // Implement login
    }

    public boolean register(String username, String password) {
        // Implement registration
    }

    public void updateScore(String username, int score) {
        // Update score
    }

    public List<User> getLeaderboard() {
        // Return top users
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }
}
import java.net.*;
import java.io.*;

public class WordProvider {
    public static String getRandomWord() throws IOException {
        URL url = new URL("https://example.com/api/word");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        return in.readLine().trim();
    }
}
//hangman game
import java.util.*;

public class HangmanGame {
    private String word;
    private Set<Character> guessedLetters;
    private int wrongGuesses;
    private final int maxGuesses = 6;

    public HangmanGame(String word) {
        this.word = word.toLowerCase();
        this.guessedLetters = new HashSet<>();
        this.wrongGuesses = 0;
    }

    public String getMaskedWord() {
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i == 0 || i == word.length() - 1 || guessedLetters.contains(word.charAt(i))) {
                masked.append(word.charAt(i));
            } else {
                masked.append('-');
            }
        }
        return masked.toString();
    }

    public boolean guess(char letter) {
        letter = Character.toLowerCase(letter);
        if (word.contains(String.valueOf(letter))) {
            guessedLetters.add(letter);
            return true;
        } else {
            wrongGuesses++;
            return false;
        }
    }

    public boolean isGameOver() {
        return isWon() || wrongGuesses >= maxGuesses;
    }

    public boolean isWon() {
        for (char c : word.toCharArray()) {
            if (c != word.charAt(0) && c != word.charAt(word.length() - 1) && !guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }
}
