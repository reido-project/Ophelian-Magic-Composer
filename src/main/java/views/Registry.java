package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class Registry extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField magicTypeInput;
	private JTextField magicLevelInput;
	private JTextField spellInput;
	private JTextField proficiencyInput;
	private JTextField textField;
	private JTextField characterNameInput;
	private JTextField characterAgeInput;
	private JTextField primaryProficiencyInput;
	private JTextField secondaryProficiencyInput;
	private JTextField tertiaryProficiencyInput;

	/**
	 * Create the frame.
	 */
	public Registry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 832);
		setResizable(false);
		setTitle("Ophelian Magic Composer");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(18, 18, 18));
		contentPane.setBorder(new EmptyBorder(30, 30, 30, 30));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Ophelian Magic Composer");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("SansSerif", Font.BOLD, 20));
		title.setBounds(406, 12, 262, 28);
		contentPane.add(title);
		
		JPanel magicRegistry = new JPanel();
		magicRegistry.setBackground(new Color(36, 31, 49));
		magicRegistry.setBounds(12, 64, 365, 273);
		contentPane.add(magicRegistry);
		magicRegistry.setLayout(null);
		
		JLabel lblMagicTypeRegistry = new JLabel("Magic Type Registry");
		lblMagicTypeRegistry.setForeground(new Color(255, 255, 255));
		lblMagicTypeRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMagicTypeRegistry.setBounds(104, 12, 159, 23);
		magicRegistry.add(lblMagicTypeRegistry);
		
		JLabel lblClass = new JLabel("Magic Class");
		lblClass.setForeground(new Color(255, 255, 255));
		lblClass.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblClass.setBounds(12, 63, 91, 17);
		magicRegistry.add(lblClass);
		
		JComboBox magicClassCombo = new JComboBox();
		magicClassCombo.setBounds(115, 58, 237, 26);
		magicRegistry.add(magicClassCombo);
		
		JLabel lblMagicType = new JLabel("Magic Type");
		lblMagicType.setForeground(Color.WHITE);
		lblMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMagicType.setBounds(12, 95, 91, 17);
		magicRegistry.add(lblMagicType);
		
		magicTypeInput = new JTextField();
		magicTypeInput.setText("Darkness");
		magicTypeInput.setBounds(115, 90, 237, 26);
		magicRegistry.add(magicTypeInput);
		magicTypeInput.setColumns(10);
		
		JLabel lblMagicLevel = new JLabel("Magic Level");
		lblMagicLevel.setForeground(Color.WHITE);
		lblMagicLevel.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMagicLevel.setBounds(12, 130, 91, 17);
		magicRegistry.add(lblMagicLevel);
		
		magicLevelInput = new JTextField();
		magicLevelInput.setHorizontalAlignment(SwingConstants.CENTER);
		magicLevelInput.setText("2");
		magicLevelInput.setColumns(10);
		magicLevelInput.setBounds(115, 125, 50, 26);
		magicRegistry.add(magicLevelInput);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblDescription.setBounds(12, 165, 91, 17);
		magicRegistry.add(lblDescription);
		
		JTextArea descriptionInput = new JTextArea();
		descriptionInput.setBounds(115, 160, 237, 60);
		magicRegistry.add(descriptionInput);
		
		JButton btnMagicSubmit = new JButton("Submit");
		btnMagicSubmit.setBounds(12, 236, 340, 27);
		magicRegistry.add(btnMagicSubmit);
		
		JPanel spellRegistry = new JPanel();
		spellRegistry.setBackground(new Color(36, 31, 49));
		spellRegistry.setBounds(12, 357, 365, 427);
		contentPane.add(spellRegistry);
		spellRegistry.setLayout(null);
		
		JLabel lblSpellRegistry = new JLabel("Spell Registry");
		lblSpellRegistry.setForeground(Color.WHITE);
		lblSpellRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSpellRegistry.setBounds(119, 12, 108, 23);
		spellRegistry.add(lblSpellRegistry);
		
		JLabel lblRegisteredMagicType = new JLabel("Magic Type");
		lblRegisteredMagicType.setForeground(Color.WHITE);
		lblRegisteredMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblRegisteredMagicType.setBounds(12, 61, 91, 17);
		spellRegistry.add(lblRegisteredMagicType);
		
		JComboBox magicTypeCombo = new JComboBox();
		magicTypeCombo.setBounds(115, 56, 237, 26);
		spellRegistry.add(magicTypeCombo);
		
		JLabel lblSpellName = new JLabel("Spell Name");
		lblSpellName.setForeground(Color.WHITE);
		lblSpellName.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblSpellName.setBounds(12, 95, 91, 17);
		spellRegistry.add(lblSpellName);
		
		spellInput = new JTextField();
		spellInput.setText("Nyx Kalytra");
		spellInput.setColumns(10);
		spellInput.setBounds(115, 90, 237, 26);
		spellRegistry.add(spellInput);
		
		JLabel lblTarget = new JLabel("Target");
		lblTarget.setForeground(Color.WHITE);
		lblTarget.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblTarget.setBounds(12, 129, 91, 17);
		spellRegistry.add(lblTarget);
		
		JComboBox targetCombo = new JComboBox();
		targetCombo.setBounds(115, 124, 237, 26);
		spellRegistry.add(targetCombo);
		
		JLabel lblRange = new JLabel("Effect Range");
		lblRange.setForeground(Color.WHITE);
		lblRange.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblRange.setBounds(12, 163, 91, 17);
		spellRegistry.add(lblRange);
		
		JCheckBox chckbxContact = new JCheckBox("Contact");
		chckbxContact.setBounds(115, 158, 114, 25);
		spellRegistry.add(chckbxContact);
		
		JCheckBox chckbxShortRange = new JCheckBox("Short Range");
		chckbxShortRange.setBounds(115, 187, 114, 25);
		spellRegistry.add(chckbxShortRange);
		
		JCheckBox chckbxLongRange = new JCheckBox("Long Range");
		chckbxLongRange.setBounds(238, 158, 114, 25);
		spellRegistry.add(chckbxLongRange);
		
		JCheckBox chckbxAreaOfEffect = new JCheckBox("Area of Effect");
		chckbxAreaOfEffect.setBounds(238, 187, 114, 25);
		spellRegistry.add(chckbxAreaOfEffect);
		
		JLabel lblMagicProficiency = new JLabel("Proficiency");
		lblMagicProficiency.setForeground(Color.WHITE);
		lblMagicProficiency.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMagicProficiency.setBounds(12, 225, 91, 17);
		spellRegistry.add(lblMagicProficiency);
		
		proficiencyInput = new JTextField();
		proficiencyInput.setText("2");
		proficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
		proficiencyInput.setColumns(10);
		proficiencyInput.setBounds(115, 220, 50, 26);
		spellRegistry.add(proficiencyInput);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setForeground(Color.WHITE);
		lblCost.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCost.setBounds(177, 225, 34, 17);
		spellRegistry.add(lblCost);
		
		textField = new JTextField();
		textField.setText("200000");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(213, 221, 139, 26);
		spellRegistry.add(textField);
		
		JLabel lblMechanism = new JLabel("Mechanism");
		lblMechanism.setForeground(Color.WHITE);
		lblMechanism.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMechanism.setBounds(12, 259, 91, 17);
		spellRegistry.add(lblMechanism);
		
		JTextArea mechanismInput = new JTextArea();
		mechanismInput.setBounds(115, 254, 237, 60);
		spellRegistry.add(mechanismInput);
		
		JLabel lblReference = new JLabel("Reference");
		lblReference.setForeground(Color.WHITE);
		lblReference.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblReference.setBounds(12, 326, 91, 17);
		spellRegistry.add(lblReference);
		
		JTextArea referenceInput = new JTextArea();
		referenceInput.setBounds(115, 321, 237, 60);
		spellRegistry.add(referenceInput);
		
		JButton btnSpellSubmit = new JButton("Submit");
		btnSpellSubmit.setBounds(12, 393, 340, 27);
		spellRegistry.add(btnSpellSubmit);
		
		JPanel characterRegistry = new JPanel();
		characterRegistry.setBackground(new Color(36, 31, 49));
		characterRegistry.setBounds(753, 357, 365, 427);
		contentPane.add(characterRegistry);
		characterRegistry.setLayout(null);
		
		JLabel lblCharacterRegistry = new JLabel("Character Registry");
		lblCharacterRegistry.setForeground(Color.WHITE);
		lblCharacterRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCharacterRegistry.setBounds(110, 12, 155, 23);
		characterRegistry.add(lblCharacterRegistry);
		
		JLabel characterName = new JLabel("Character Name");
		characterName.setForeground(Color.WHITE);
		characterName.setFont(new Font("SansSerif", Font.BOLD, 13));
		characterName.setBounds(12, 58, 109, 17);
		characterRegistry.add(characterName);
		
		characterNameInput = new JTextField();
		characterNameInput.setText("Apocryptia von Ophelius");
		characterNameInput.setColumns(10);
		characterNameInput.setBounds(135, 53, 217, 26);
		characterRegistry.add(characterNameInput);
		
		JLabel lblCharacterRole = new JLabel("Character Role");
		lblCharacterRole.setForeground(Color.WHITE);
		lblCharacterRole.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCharacterRole.setBounds(12, 92, 109, 17);
		characterRegistry.add(lblCharacterRole);
		
		JComboBox characterRoleCombo = new JComboBox();
		characterRoleCombo.setBounds(135, 87, 217, 26);
		characterRegistry.add(characterRoleCombo);
		
		JLabel lblCharacterAge = new JLabel("Character Age");
		lblCharacterAge.setForeground(Color.WHITE);
		lblCharacterAge.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCharacterAge.setBounds(12, 129, 109, 17);
		characterRegistry.add(lblCharacterAge);
		
		characterAgeInput = new JTextField();
		characterAgeInput.setText("53");
		characterAgeInput.setHorizontalAlignment(SwingConstants.CENTER);
		characterAgeInput.setColumns(10);
		characterAgeInput.setBounds(135, 125, 50, 26);
		characterRegistry.add(characterAgeInput);
		
		JLabel lblCharacterMagicType = new JLabel("Character's Magic Type");
		lblCharacterMagicType.setForeground(Color.WHITE);
		lblCharacterMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCharacterMagicType.setBounds(42, 163, 155, 17);
		characterRegistry.add(lblCharacterMagicType);
		
		JLabel lblCharacterProficiency = new JLabel("Proficiency");
		lblCharacterProficiency.setForeground(Color.WHITE);
		lblCharacterProficiency.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCharacterProficiency.setBounds(280, 163, 73, 17);
		characterRegistry.add(lblCharacterProficiency);
		
		JComboBox primaryMagicTypeCombo = new JComboBox();
		primaryMagicTypeCombo.setBounds(12, 192, 217, 26);
		characterRegistry.add(primaryMagicTypeCombo);
		
		primaryProficiencyInput = new JTextField();
		primaryProficiencyInput.setText("3");
		primaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
		primaryProficiencyInput.setColumns(10);
		primaryProficiencyInput.setBounds(292, 192, 50, 26);
		characterRegistry.add(primaryProficiencyInput);
		
		JComboBox secondaryMagicTypeCombo = new JComboBox();
		secondaryMagicTypeCombo.setBounds(12, 224, 217, 26);
		characterRegistry.add(secondaryMagicTypeCombo);
		
		secondaryProficiencyInput = new JTextField();
		secondaryProficiencyInput.setText("2");
		secondaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
		secondaryProficiencyInput.setColumns(10);
		secondaryProficiencyInput.setBounds(292, 224, 50, 26);
		characterRegistry.add(secondaryProficiencyInput);
		
		JComboBox tertiaryMagicTypeCombo = new JComboBox();
		tertiaryMagicTypeCombo.setBounds(12, 255, 217, 26);
		characterRegistry.add(tertiaryMagicTypeCombo);
		
		tertiaryProficiencyInput = new JTextField();
		tertiaryProficiencyInput.setText("1");
		tertiaryProficiencyInput.setHorizontalAlignment(SwingConstants.CENTER);
		tertiaryProficiencyInput.setColumns(10);
		tertiaryProficiencyInput.setBounds(292, 255, 50, 26);
		characterRegistry.add(tertiaryProficiencyInput);
		
		JLabel lblCDescription = new JLabel("Description");
		lblCDescription.setForeground(Color.WHITE);
		lblCDescription.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCDescription.setBounds(12, 298, 91, 17);
		characterRegistry.add(lblCDescription);
		
		JTextArea cDescriptionInput = new JTextArea();
		cDescriptionInput.setBounds(115, 293, 237, 60);
		characterRegistry.add(cDescriptionInput);
		
		JButton btnCharacterSubmit = new JButton("Submit");
		btnCharacterSubmit.setBounds(12, 365, 340, 27);
		characterRegistry.add(btnCharacterSubmit);
		
		JPanel characterSelector = new JPanel();
		characterSelector.setLayout(null);
		characterSelector.setBackground(new Color(36, 31, 49));
		characterSelector.setBounds(753, 64, 365, 273);
		contentPane.add(characterSelector);
		
		JLabel lblCharacterSelector = new JLabel("Character Selector");
		lblCharacterSelector.setForeground(Color.WHITE);
		lblCharacterSelector.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCharacterSelector.setBounds(106, 12, 159, 23);
		characterSelector.add(lblCharacterSelector);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 47, 341, 214);
		characterSelector.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		JPanel characterSpellRegistry = new JPanel();
		characterSpellRegistry.setLayout(null);
		characterSpellRegistry.setBackground(new Color(36, 31, 49));
		characterSpellRegistry.setBounds(382, 64, 365, 521);
		contentPane.add(characterSpellRegistry);
		
		JLabel lblCharacterSpellRegistry = new JLabel("Character Spell Registry");
		lblCharacterSpellRegistry.setForeground(Color.WHITE);
		lblCharacterSpellRegistry.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCharacterSpellRegistry.setBounds(84, 12, 191, 23);
		characterSpellRegistry.add(lblCharacterSpellRegistry);
		
		JLabel lblInfoName = new JLabel("Name:");
		lblInfoName.setForeground(Color.WHITE);
		lblInfoName.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblInfoName.setBounds(12, 57, 54, 17);
		characterSpellRegistry.add(lblInfoName);
		
		JLabel infoName = new JLabel("New label");
		infoName.setForeground(new Color(255, 255, 255));
		infoName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		infoName.setBounds(66, 57, 60, 17);
		characterSpellRegistry.add(infoName);
		
		JLabel lblInfoRole = new JLabel("Role:");
		lblInfoRole.setForeground(Color.WHITE);
		lblInfoRole.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblInfoRole.setBounds(12, 78, 54, 17);
		characterSpellRegistry.add(lblInfoRole);
		
		JLabel infoRole = new JLabel("New label");
		infoRole.setForeground(Color.WHITE);
		infoRole.setFont(new Font("SansSerif", Font.PLAIN, 12));
		infoRole.setBounds(66, 78, 60, 17);
		characterSpellRegistry.add(infoRole);
		
		JLabel lblInfoAge = new JLabel("Age:");
		lblInfoAge.setForeground(Color.WHITE);
		lblInfoAge.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblInfoAge.setBounds(12, 100, 54, 17);
		characterSpellRegistry.add(lblInfoAge);
		
		JLabel infoAge = new JLabel("New label");
		infoAge.setForeground(Color.WHITE);
		infoAge.setFont(new Font("SansSerif", Font.PLAIN, 12));
		infoAge.setBounds(66, 100, 60, 17);
		characterSpellRegistry.add(infoAge);
		
		JLabel lblSelectMagicType = new JLabel("Select Character's Magic Type");
		lblSelectMagicType.setForeground(Color.WHITE);
		lblSelectMagicType.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblSelectMagicType.setBounds(84, 136, 199, 17);
		characterSpellRegistry.add(lblSelectMagicType);
		
		JComboBox magicTypeSelectCombo = new JComboBox();
		magicTypeSelectCombo.setBounds(74, 165, 217, 26);
		characterSpellRegistry.add(magicTypeSelectCombo);
		
		JScrollPane characterSpellScrollPane = new JScrollPane();
		characterSpellScrollPane.setBounds(12, 215, 341, 245);
		characterSpellRegistry.add(characterSpellScrollPane);
		
		JPanel characterSpellScrollViewport = new JPanel();
		characterSpellScrollPane.setViewportView(characterSpellScrollViewport);
		
		JButton btnCharacterSpellSubmit = new JButton("Submit");
		btnCharacterSpellSubmit.setBounds(12, 482, 340, 27);
		characterSpellRegistry.add(btnCharacterSpellSubmit);
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(389, 610, 352, 50);
		contentPane.add(refreshBtn);
		
		JButton exportBtn = new JButton("Export");
		exportBtn.setBounds(389, 672, 352, 50);
		contentPane.add(exportBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(389, 734, 352, 50);
		contentPane.add(exitBtn);

	}
}
