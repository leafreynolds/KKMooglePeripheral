package leaf.kkmoogleinterface.functions;

import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;
import leaf.kkmoogleinterface.functions.moogleprojector.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class FunctionsHandler
{
	private static HashMap<String, IFunction> functions = new HashMap<>();

	public static void init()
	{
		registerAll(
				new RunTest(),
				new GetKeybladeList(),
				new GetKeyblade()
		);
	}

	public static void register(IFunction function)
	{
		functions.put(function.getName(), function);
	}

	public static void registerAll(IFunction... functions)
	{
		for (IFunction function : functions)
		{
			register(function);
		}
	}

	public static String[] getFunctionsNames()
	{
		return functions.keySet().toArray(new String[0]);
	}

	public MethodResult run(String functionName, IArguments args) throws LuaException
	{
		Optional<IFunction> function = Optional.ofNullable(functions.get(functionName));
		if (function.isPresent())
		{
			return function.get().run(args);
		}
		return MethodResult.of();
	}


}
