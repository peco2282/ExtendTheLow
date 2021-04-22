package onim.en.etl.ui.parts;

import java.util.HashMap;

import com.google.common.collect.Maps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import onim.en.etl.ui.RenderingContext;
import onim.en.etl.util.GuiUtil;

public abstract class ComponentBase extends Gui {

  public boolean visible = true;
  public boolean enabled = true;
  public boolean hovered = false;

  public int width;
  public int height;

  public int paddingTop = 4;
  public int paddingBottom = 4;

  public String tooltipText = null;

  public static class Registry {
    private static HashMap<Integer, ComponentBase> components = Maps.newHashMap();

    public static int nextComponent(ComponentBase component) {
      int id = components.size();
      components.put(id, component);
      return id;
    }

    public static ComponentBase getButton(int id) {
      return components.get(id);
    }
  }

  public final int id;

  public ComponentBase() {
    this.id = Registry.nextComponent(this);
  }

  public abstract int draw(Minecraft mc);

  public void update() {

  }

  public void mousePressed(int button) {

  }

  public void mouseReleased(int button, boolean isInside) {

  }

  public void mouseDragged() {

  }
  
  public int drawTrimedStringWithLeader(String s, int width, boolean centered) {
    return this.drawTrimedStringWithLeader(s, width, centered, false);
  }

  public int drawTrimedStringWithLeader(String s, int width, boolean centered, boolean shadow) {
    FontRenderer f = Minecraft.getMinecraft().fontRendererObj;

    if (f.getStringWidth(s) > width) {
      tooltipText = s;
      String leader = "...";
      s = f.trimStringToWidth(s, width - f.getStringWidth(leader)) + leader;
    } else {
      tooltipText = null;
    }

    int i = f.getStringWidth(s);

    RenderingContext ctx = RenderingContext.current;
    return f.drawString(s, ctx.x + (centered ? -i / 2 : 0), ctx.y, ctx.color, shadow);
  }

  public void renderTooltip(String s, int x, int y) {
    FontRenderer f = Minecraft.getMinecraft().fontRendererObj;

    GlStateManager.pushMatrix();
    GlStateManager.translate(0, 0, 100);

    int i = f.getStringWidth(s);
    GuiUtil.drawGradientRectHorizontal(x - 2, y - 2, x + i + 6, y + 14, 0xEE669966, 0xEE336699);
    GuiUtil.drawGradientRectHorizontal(x - 1, y - 1, x + i + 5, y + 13, 0xEE336699, 0xEE669999);

    f.drawString(s, x + 2, y + 2, 0xFFFFFF);

    GlStateManager.popMatrix();
  }

}

