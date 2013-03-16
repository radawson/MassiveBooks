package com.massivecraft.massivebooks.cmd;

import com.massivecraft.massivebooks.ConfServer;
import com.massivecraft.massivebooks.Perm;
import com.massivecraft.mcore.cmd.arg.ARBoolean;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;
import com.massivecraft.mcore.cmd.req.ReqIsPlayer;

public class CmdBookAutoupdate extends MassiveBooksCommand
{
	public CmdBookAutoupdate()
	{
		super();
		this.addAliases(ConfServer.aliasesBookAutoupdate);
		this.addOptionalArg("true/false", "toggle");
		this.addRequirements(ReqHasPerm.get(Perm.AUTOUPDATE.node));
		this.addRequirements(ReqIsPlayer.get());
	}
	
	@Override
	public void perform()
	{
		boolean currentState = mme.isUsingAutoUpdate();
		Boolean targetState = this.arg(0, ARBoolean.get(), !currentState);
		if (targetState == null) return;
		mme.setUsingAutoUpdate(targetState, true, true);
	}
}