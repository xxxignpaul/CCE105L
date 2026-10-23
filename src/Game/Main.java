package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private GameCharacter player;
    private GameCharacter enemy;

    private final Random random = new Random();

    private int potions = 3;
    private boolean battleOver = false;

    private JLabel playerNameLabel;
    private JLabel enemyNameLabel;
    private JLabel potionLabel;
    private JLabel statusLabel;

    private JProgressBar playerHealthBar;
    private JProgressBar enemyHealthBar;

    private JTextArea battleLog;

    private JButton attackButton;
    private JButton specialButton;
    private JButton healButton;
    private JButton runButton;

    private final Color BACKGROUND = new Color(24, 28, 40);
    private final Color PANEL_COLOR = new Color(36, 42, 58);
    private final Color TEXT_COLOR = new Color(240, 243, 250);
    private final Color BLUE = new Color(65, 130, 230);
    private final Color GREEN = new Color(50, 180, 110);
    private final Color RED = new Color(220, 75, 85);
    private final Color PURPLE = new Color(145, 90, 220);

    public Main() {
        setTitle("Java RPG Battle");
        setSize(900, 700);
        setMinimumSize(new Dimension(780, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showCharacterSelection();
    }

    private void showCharacterSelection() {

        // Use List<GameCharacter> ADT with ArrayList implementation for character management
        List<GameCharacter> characters = new ArrayList<>();

        characters.add(new Warrior("Warrior"));
        characters.add(new Mage("Mage"));
        characters.add(new Archer("Archer"));
        characters.add(new Paladin("Paladin"));
        characters.add(new Assassin("Assassin"));
        characters.add(new Necromancer("Necromancer"));
        characters.add(new Berserker("Berserker"));

        JPanel panel = new JPanel();
        panel.setBackground(BACKGROUND);
        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("JAVA RPG BATTLE");
        title.setFont(new Font("SansSerif", Font.BOLD, 34));
        title.setForeground(TEXT_COLOR);
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel(
                "Choose your hero and enter the arena");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 15));
        subtitle.setForeground(Color.LIGHT_GRAY);
        subtitle.setAlignmentX(CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Character Name");
        nameLabel.setForeground(TEXT_COLOR);
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);

        JTextField nameField = new JTextField("Hero");
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        nameField.setMaximumSize(new Dimension(320, 38));

        JLabel classLabel = new JLabel("Choose Your Class");
        classLabel.setForeground(TEXT_COLOR);
        classLabel.setAlignmentX(CENTER_ALIGNMENT);

        JComboBox<String> classChoice = new JComboBox<>(
                new String[] {
                    "Warrior - High health and defense",
                    "Mage - High magical damage",
                    "Archer - Balanced combat",
                    "Paladin - Holy tank and healer",
                    "Assassin - Burst damage",
                    "Necromancer - Life drain magic",
                    "Berserker - Heavy damage"
                });

        classChoice.setFont(new Font("SansSerif", Font.PLAIN, 14));
        classChoice.setMaximumSize(new Dimension(380, 40));

        JButton startButton = new JButton("START BATTLE");
        styleButton(startButton, GREEN);
        startButton.setAlignmentX(CENTER_ALIGNMENT);

        startButton.addActionListener(e -> {

            String name = nameField.getText().trim();

            if (name.isEmpty()) {
                name = "Hero";
            }

            switch (classChoice.getSelectedIndex()) {
                case 0:
                    player = new Warrior(name);
                    break;
                case 1:
                    player = new Mage(name);
                    break;
                case 2:
                    player = new Archer(name);
                    break;
                case 3:
                    player = new Paladin(name);
                    break;
                case 4:
                    player = new Assassin(name);
                    break;
                case 5:
                    player = new Necromancer(name);
                    break;
                case 6:
                    player = new Berserker(name);
                    break;
                default:
                    player = new Warrior(name);
                    break;
            }

            enemy = createEnemy();

            potions = 3;
            battleOver = false;

            showBattleScreen();
        });

        panel.add(Box.createVerticalGlue());
        panel.add(title);
        panel.add(Box.createVerticalStrut(10));
        panel.add(subtitle);
        panel.add(Box.createVerticalStrut(35));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(nameField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(classLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(classChoice);
        panel.add(Box.createVerticalStrut(25));
        panel.add(startButton);
        panel.add(Box.createVerticalGlue());

        setContentPane(panel);
        revalidate();
        repaint();
    }

    private GameCharacter createEnemy() {

        int choice;

        do {
            choice = random.nextInt(7);
        } while (
                (choice == 0 && player instanceof Warrior)
                || (choice == 1 && player instanceof Mage)
                || (choice == 2 && player instanceof Archer)
                || (choice == 3 && player instanceof Paladin)
                || (choice == 4 && player instanceof Assassin)
                || (choice == 5 && player instanceof Necromancer)
                || (choice == 6 && player instanceof Berserker)
        );

        switch (choice) {
            case 0:
                return new Warrior("Enemy Warrior");
            case 1:
                return new Mage("Enemy Mage");
            case 2:
                return new Archer("Enemy Archer");
            case 3:
                return new Paladin("Enemy Paladin");
            case 4:
                return new Assassin("Enemy Assassin");
            case 5:
                return new Necromancer("Enemy Necromancer");
            default:
                return new Berserker("Enemy Berserker");
        }
    }

    private void showBattleScreen() {

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(BACKGROUND);
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel(
                "BATTLE ARENA", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(TEXT_COLOR);

        mainPanel.add(title, BorderLayout.NORTH);

        JPanel characters = new JPanel(
                new GridLayout(1, 2, 15, 0));
        characters.setBackground(BACKGROUND);

        characters.add(createCharacterPanel(true));
        characters.add(createCharacterPanel(false));

        battleLog = new JTextArea();
        battleLog.setEditable(false);
        battleLog.setLineWrap(true);
        battleLog.setWrapStyleWord(true);
        battleLog.setFont(new Font("Monospaced", Font.PLAIN, 13));
        battleLog.setBackground(new Color(17, 20, 29));
        battleLog.setForeground(TEXT_COLOR);
        battleLog.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane logScroll = new JScrollPane(battleLog);
        logScroll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Battle Log"));

        JPanel centerPanel = new JPanel(new BorderLayout(0, 15));
        centerPanel.setBackground(BACKGROUND);
        centerPanel.add(characters, BorderLayout.NORTH);
        centerPanel.add(logScroll, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel actions = new JPanel(new GridLayout(2, 2, 10, 10));
        actions.setBackground(BACKGROUND);

        attackButton = new JButton("ATTACK");
        specialButton = new JButton("SPECIAL MOVE");
        healButton = new JButton("HEAL");
        runButton = new JButton("RUN");

        styleButton(attackButton, BLUE);
        styleButton(specialButton, PURPLE);
        styleButton(healButton, GREEN);
        styleButton(runButton, RED);

        attackButton.addActionListener(e -> playerAttack());
        specialButton.addActionListener(e -> playerSpecial());
        healButton.addActionListener(e -> playerHeal());
        runButton.addActionListener(e -> runAway());

        actions.add(attackButton);
        actions.add(specialButton);
        actions.add(healButton);
        actions.add(runButton);

        potionLabel = new JLabel();
        potionLabel.setForeground(TEXT_COLOR);
        potionLabel.setFont(new Font("SansSerif", Font.BOLD, 13));

        statusLabel = new JLabel("Your turn!");
        statusLabel.setForeground(TEXT_COLOR);
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JPanel bottom = new JPanel(new BorderLayout(0, 8));
        bottom.setBackground(BACKGROUND);
        bottom.add(statusLabel, BorderLayout.NORTH);
        bottom.add(potionLabel, BorderLayout.CENTER);
        bottom.add(actions, BorderLayout.SOUTH);

        mainPanel.add(bottom, BorderLayout.SOUTH);

        setContentPane(mainPanel);

        updateDisplay();

        log("A battle has begun!");
        log(player.getName() + " (" 
                + player.getClass().getSimpleName() + ")");
        log("Enemy: " + enemy.getName() + " ("
                + enemy.getClass().getSimpleName() + ")");
        log("Choose your action.");

        revalidate();
        repaint();
    }

    private JPanel createCharacterPanel(boolean isPlayer) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(PANEL_COLOR);

        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        isPlayer ? BLUE : RED, 2),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        JLabel roleLabel = new JLabel(
                isPlayer ? "YOUR HERO" : "OPPONENT");
        roleLabel.setForeground(Color.LIGHT_GRAY);
        roleLabel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel();
        nameLabel.setForeground(TEXT_COLOR);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);

        JProgressBar healthBar = new JProgressBar(0, 100);
        healthBar.setStringPainted(true);
        healthBar.setForeground(isPlayer ? GREEN : RED);
        healthBar.setBackground(Color.DARK_GRAY);
        healthBar.setPreferredSize(new Dimension(300, 25));
        healthBar.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 25));

        panel.add(roleLabel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(healthBar);
        panel.add(Box.createVerticalStrut(10));

        if (isPlayer) {
            playerNameLabel = nameLabel;
            playerHealthBar = healthBar;
        } else {
            enemyNameLabel = nameLabel;
            enemyHealthBar = healthBar;
        }

        return panel;
    }

    private void styleButton(JButton button, Color color) {

        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(150, 45));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void playerAttack() {

        if (battleOver) {
            return;
        }

        int oldHealth = enemy.getHealth();

        player.attack(enemy);

        log(player.getName() + " used a normal attack!");
        logDamage(enemy, oldHealth);

        finishPlayerTurn();
    }

    private void playerSpecial() {

        if (battleOver) {
            return;
        }

        if (!player.canUseSpecial()) {
            log("Special move is on cooldown: "
                    + player.getSpecialCooldown()
                    + " turn(s) remaining.");
            return;
        }

        int oldEnemyHealth = enemy.getHealth();
        int oldPlayerHealth = player.getHealth();

        player.specialMove(enemy);
        player.startSpecialCooldown();

        log(player.getName() + " used "
                + getSpecialName(player) + "!");

        logDamage(enemy, oldEnemyHealth);

        if (player.getHealth() > oldPlayerHealth) {
            log(player.getName() + " recovered "
                    + (player.getHealth() - oldPlayerHealth)
                    + " HP!");
        }

        finishPlayerTurn();
    }

    private String getSpecialName(GameCharacter character) {

        if (character instanceof Warrior) {
            return "HEAVY SLASH";
        }

        if (character instanceof Mage) {
            return "FIRE STORM";
        }

        if (character instanceof Archer) {
            return "CRITICAL SHOT";
        }

        if (character instanceof Paladin) {
            return "DIVINE JUDGMENT";
        }

        if (character instanceof Assassin) {
            return "SHADOW STRIKE";
        }

        if (character instanceof Necromancer) {
            return "SOUL DRAIN";
        }

        if (character instanceof Berserker) {
            return "RAGING ONSLAUGHT";
        }

        return "SPECIAL ATTACK";
    }

    private void playerHeal() {

        if (battleOver) {
            return;
        }

        if (potions <= 0) {
            log("You have no healing potions left!");
            return;
        }

        if (player.getHealth() == player.getMaxHealth()) {
            log("Your health is already full!");
            return;
        }

        int healed = player.heal(40);
        potions--;

        log(player.getName() + " used a healing potion.");
        log("Recovered " + healed + " HP.");
        log("Potions remaining: " + potions);

        finishPlayerTurn();
    }

    private void runAway() {

        if (battleOver) {
            return;
        }

        battleOver = true;

        log(player.getName() + " escaped from battle!");

        updateDisplay();
        disableActions();

        statusLabel.setText("You escaped!");

        showEndDialog("You escaped from the battle!");
    }

    private void finishPlayerTurn() {

        updateDisplay();

        if (!enemy.isAlive()) {
            endBattle(true);
            return;
        }

        statusLabel.setText("Enemy's turn...");

        disableActions();

        enemyTurn();

        player.reduceCooldown();
        enemy.reduceCooldown();

        updateDisplay();

        if (!player.isAlive()) {
            endBattle(false);
            return;
        }

        statusLabel.setText("Your turn!");

        enableActions();
        updateDisplay();
    }

    private void enemyTurn() {

        if (!enemy.isAlive() || !player.isAlive()) {
            return;
        }

        int oldPlayerHealth = player.getHealth();
        int oldEnemyHealth = enemy.getHealth();

        if (enemy.canUseSpecial()
                && random.nextInt(100) < 30) {

            enemy.specialMove(player);
            enemy.startSpecialCooldown();

            log(enemy.getName() + " used "
                    + getSpecialName(enemy) + "!");
        } else {
            enemy.attack(player);
            log(enemy.getName() + " attacked!");
        }

        logDamage(player, oldPlayerHealth);

        if (enemy.getHealth() > oldEnemyHealth) {
            log(enemy.getName() + " recovered health!");
        }
    }

    private void logDamage(GameCharacter target, int oldHealth) {

        int damage = oldHealth - target.getHealth();

        if (damage > 0) {
            log(target.getName() + " lost " + damage + " HP.");
        }

        if (!target.isAlive()) {
            log(target.getName() + " has been defeated!");
        }
    }

    private void updateDisplay() {

        if (player == null || enemy == null
                || playerHealthBar == null
                || enemyHealthBar == null) {
            return;
        }

        playerNameLabel.setText(player.getName());
        enemyNameLabel.setText(enemy.getName());

        playerHealthBar.setMaximum(player.getMaxHealth());
        playerHealthBar.setValue(player.getHealth());
        playerHealthBar.setString(
                player.getHealth() + " / "
                + player.getMaxHealth() + " HP");

        enemyHealthBar.setMaximum(enemy.getMaxHealth());
        enemyHealthBar.setValue(enemy.getHealth());
        enemyHealthBar.setString(
                enemy.getHealth() + " / "
                + enemy.getMaxHealth() + " HP");

        potionLabel.setText("Healing Potions: " + potions);

        specialButton.setEnabled(
                !battleOver && player.canUseSpecial());

        if (player.getSpecialCooldown() > 0) {
            specialButton.setToolTipText(
                    "Cooldown: "
                    + player.getSpecialCooldown()
                    + " turn(s)");
        } else {
            specialButton.setToolTipText("Ready to use!");
        }

        revalidate();
        repaint();
    }

    private void log(String message) {

        if (battleLog != null) {
            battleLog.append(message + "\n");
            battleLog.setCaretPosition(
                    battleLog.getDocument().getLength());
        }
    }

    private void disableActions() {

        attackButton.setEnabled(false);
        specialButton.setEnabled(false);
        healButton.setEnabled(false);
        runButton.setEnabled(false);
    }

    private void enableActions() {

        if (battleOver) {
            return;
        }

        attackButton.setEnabled(true);
        specialButton.setEnabled(player.canUseSpecial());
        healButton.setEnabled(
                potions > 0
                && player.getHealth() < player.getMaxHealth());
        runButton.setEnabled(true);
    }

    private void endBattle(boolean playerWon) {

        if (battleOver) {
            return;
        }

        battleOver = true;

        disableActions();

        String result;

        if (playerWon) {
            result = "VICTORY! You defeated "
                    + enemy.getName() + "!";
        } else {
            result = "DEFEAT! " + enemy.getName()
                    + " won the battle.";
        }

        statusLabel.setText(
                playerWon ? "Victory!" : "Defeat!");

        log(result);

        showEndDialog(result);
    }

    private void showEndDialog(String message) {

        int choice = JOptionPane.showConfirmDialog(
                this,
                message + "\n\nWould you like to play again?",
                "Battle Result",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            player = null;
            enemy = null;

            playerHealthBar = null;
            enemyHealthBar = null;

            showCharacterSelection();
        } else {
            dispose();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Main game = new Main();
            game.setVisible(true);
        });
    }
}
