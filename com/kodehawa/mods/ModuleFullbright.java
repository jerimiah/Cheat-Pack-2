/*
* Copyright (c) 2013 David Rubio
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

package com.kodehawa.mods;

import net.minecraft.src.Minecraft;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.util.ChatColour;
import com.kodehawa.util.Tickable;

public class ModuleFullbright extends Mod implements Tickable
{
    public ModuleFullbright(CheatingEssentials rc, Minecraft mc)
    {
        super(Mods.Fullbright);
        cb = rc;
        minecraft = mc;
    }

    @Override
    public void onEnable()
    {
        cb.addToTick(this);
    }

    @Override
    public void onDisable()
    {
        
        minecraft.gameSettings.gammaSetting = 0.5F;
        cb.removeFromCurrentTick(this);
    }

    @Override
    public void tick()
    {
        minecraft.gameSettings.gammaSetting++;
    }

    private final CheatingEssentials cb;
    private final Minecraft minecraft;
}
