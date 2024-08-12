import { BulmaCSS } from "../lib/BulmaCSS";

export class Startup {
  private readonly main = document.querySelector("main");
  private readonly footer = document.querySelector("#main-footer");
  private readonly bulmaCSS = new BulmaCSS();

  private run() {
    this.configureBulmaCSS();

    this.configureMainMinHeight();
  }

  private configureBulmaCSS() {
    this.bulmaCSS.animateNavMenu();
    this.bulmaCSS.listenAllThemeButton();

    this.bulmaCSS.updateColorSchema(this.bulmaCSS.recoveryDefinedColorSchema());
  }

  private configureMainMinHeight() {
    if (!this.main) return console.error("Main not defined");
    if (!this.footer) return console.error("Main Footer not defined");

    this.main.style.minHeight = `calc(100vh - ${this.footer.clientHeight}px)`;
  }

  public manageGlobalInstances() {
    return { run: () => this.run() };
  }

  public static get fast() {
    return new Startup();
  }
}
