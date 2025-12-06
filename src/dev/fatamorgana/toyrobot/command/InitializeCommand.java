package dev.fatamorgana.toyrobot.command;

import dev.fatamorgana.toyrobot.model.Robot;
import dev.fatamorgana.toyrobot.model.TableTop;

public interface InitializeCommand {
	Robot init(TableTop tableTop);
}
