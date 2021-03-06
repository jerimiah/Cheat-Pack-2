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

package com.kodehawa.gui.api.components;

import com.kodehawa.CheatingEssentials;

public abstract class Item
{
    /**
     * Reference to the main class
     */
    public CheatingEssentials c;
    

    /**
     * Parent frame
     */
    public Frame parent;

    /**
     * How to color it
     */
    public int color;

    /**
     * Used for determining whether to do a gradient quad
     */
    public int color2 = -1;

    /**
     * X position
     */
    public int x = 0;

    /**
     * Y position
     */
    public int y = 0;

    /**
     * Width
     */
    int width = 0;

    /**
     * Height
     */
    int height = 0;

    /**
     * Can it be dragged?
     */
    public boolean draggable;

    /**
     * Is it currently being dragged?
     */
    public boolean dragging;

    /**
     * Is it active? Ie do we activate the bound hack?
     */
    public boolean active;

    /**
     * String to render on it
     */
    public String text;

    /**
     * Drawing the thing is important too, you know?
     */
    public abstract void draw();

    /**
     * Updates. (Would) Handle[s] updating text,...
     */
    public void update()
    {
        draw();
    }

    /**
     * Drags the item
     */
    public abstract void drag(int x, int y);

    /**
     * Sets the item's state to the given boolean. Args: State
     *
     * @param tof
     */
    public void setActive(boolean tof)
    {
        this.active = tof;
    }

    /**
     * Updates the text to the given string. Args: New text
     *
     * @param text
     */
    public void updateText(String text)
    {
        this.text = text;
    }

    /**
     * Returns true if the component is being dragged
     *
     * @return
     */
    public boolean isDragging()
    {
        if (draggable)
        {
            if (dragging)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Sets the dragging state. Args: New state
     */
    public void setDragging(boolean state)
    {
        this.dragging = state;
    }

    /**
     * Sets whether this Item is draggable
     *
     * @param tof
     */
    public void setDraggable(boolean tof)
    {
        this.draggable = tof;
    }

    public boolean isDraggable()
    {
        if (draggable)
        {
            return true;
        }

        return false;
    }

    /**
     * Handles mouse clicks
     *
     * @param x
     * @param y
     */
    public abstract void onClick(int x, int y);

    /**
     * Converts a hex value into a float[] we can use with glColor4f(...)
     *
     * @param hex
     * @return
     */
    public static float[ ] hexToRGBA(int hex)
    {
        float r = ((hex >> 16) & 255) / 255F;
        float g = ((hex >> 8) & 255) / 255F;
        float b = (hex & 255) / 255F;
        float a = ((hex >> 24) & 255) / 255F;
        return new float[ ] { r, g, b, a };
    }

    /**
     * Returns true if the mouse has clicked inside the component
     *
     * @param x
     * @param y
     * @return
     */
    public boolean clickedInside(int x, int y)
    {
        if (x > this.x)
        {
            if (y > this.y)
            {
                if (x < (this.x + this.width))
                {
                    if (y < (this.y + this.height))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void setParent(Frame e, int x, int y)
    {
        this.parent = e;
        this.x = x;
        this.y = y;
    }

    /**
     * Would, theoretically, be used for recoloring buttons when they're moused
     * over.
     *
     * @param x
     * @param y
     * @return
     */
    public abstract boolean mouseOver(int x, int y);
}
