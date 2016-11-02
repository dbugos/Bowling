import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//GUI that represents a bowling score board at any particular point in the game.
public class ScoreBoardGui {

	public static void displayScoreBoard(Game game) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Object[] columnNames = { "Name", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "Total" };

		Object[][] rowData = new Object[game.getNumPlayers()][12];

		for (int i = 0; i < game.getNumPlayers(); i++) {
			rowData[i][0] = game.getPlayers().get(i).getName();

			for (int j = 1; j <= 10; j++) {
				StringBuilder sBuilder = new StringBuilder();
				if (j == 10) {
					if (game.getPlayers().get(i).getFrames().get(j - 1).getFirstRoll() == 10) {
						sBuilder.append("X");
						if (game.getPlayers().get(i).getFrames().get(j - 1).getSecondRoll() == 10) {
							sBuilder.append(" , ");
							sBuilder.append("X");
							if (game.getPlayers().get(i).getFrames().get(j - 1).getSecondRoll() == 10) {
								sBuilder.append(" , ");
								sBuilder.append("X");
							}
						}
					} else if (game.getPlayers().get(i).getFrames().get(j - 1).isSpare()) {
						sBuilder.append(game.getPlayers().get(i).getFrames().get(j - 1).getFirstRoll());
						sBuilder.append(" ");
						sBuilder.append("/");
						sBuilder.append(" ");
						sBuilder.append(game.getPlayers().get(i).getFrames().get(j - 1).getThirdRoll());
					} else {
						sBuilder.append(game.getPlayers().get(i).getFrames().get(j - 1).getFirstRoll());
						sBuilder.append(" , ");
						sBuilder.append(game.getPlayers().get(i).getFrames().get(j - 1).getSecondRoll());
					}

				} else {
					if (game.getPlayers().get(i).getFrames().get(j).isStrike()) {
						sBuilder.append(" X ");
					} else if (game.getPlayers().get(i).getFrames().get(j).isSpare()) {
						sBuilder.append(game.getPlayers().get(i).getFrames().get(j).getFirstRoll());
						sBuilder.append(" ");
						sBuilder.append("/");
					} else {
						sBuilder.append(game.getPlayers().get(i).getFrames().get(j).getFirstRoll());
						sBuilder.append(" ");
						sBuilder.append(game.getPlayers().get(i).getFrames().get(j).getSecondRoll());
					}
				}
				rowData[i][j] = sBuilder.toString();
			}
			rowData[i][11] = game.getPlayers().get(i).getScore();
		}
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(700, 150);
		frame.setVisible(true);
	}

}
