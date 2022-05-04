package leaf.kkmoogleinterface.peripheral;

import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IDynamicPeripheral;
import dan200.computercraft.api.peripheral.IPeripheral;
import leaf.kkmoogleinterface.functions.FunctionsHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MooglePeripheral implements IDynamicPeripheral
{
	private final FunctionsHandler functionsHandler = new FunctionsHandler();

	@Nonnull
	@Override
	public String[] getMethodNames()
	{
		return FunctionsHandler.getFunctionsNames();
	}

	@Nonnull
	@Override
	public MethodResult callMethod(@Nonnull IComputerAccess computer, @Nonnull ILuaContext context, int method, @Nonnull IArguments arguments) throws LuaException
	{
		try
		{
			final String functionName = FunctionsHandler.getFunctionsNames()[method];
			return functionsHandler.run(functionName, arguments);
		}
		catch (Exception e)
		{
			throw new LuaException(e.getMessage());
		}
	}

	@Nonnull
	@Override
	public String getType()
	{
		return "moogle";
	}

	@Override
	public boolean equals(@Nullable IPeripheral other)
	{
		return this == other;
	}
}
