package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Relogio {
	
	public static void main(String[] args) {
		// Data
				Date hoje = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));

				String dataExtenso = formatador.format(hoje);

				System.out.println(dataExtenso);
				//dataLabel.setText(dataExtenso);

				// Relogio
				Timer timer = null;
				final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				Date tempo = new Date();

				if (timer == null) {
					timer = new Timer();
					TimerTask tarefa = new TimerTask() {
						@SuppressWarnings("deprecation")
						public void run() {
							try {
								if (tempo.getSeconds() == 60) {
									tempo.setMinutes(tempo.getMinutes() + 1);
									tempo.setSeconds(0);
								}
								if (tempo.getMinutes() == 60) {
									tempo.setHours(tempo.getHours() + 1);
									tempo.setMinutes(0);

								}

								tempo.setSeconds(tempo.getSeconds() + 1);
								System.out.println(format.format(tempo));
								//horarioLabel.setText(format.format(tempo));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					};
					timer.scheduleAtFixedRate(tarefa, 0, 1000);
				}
			}
		}

