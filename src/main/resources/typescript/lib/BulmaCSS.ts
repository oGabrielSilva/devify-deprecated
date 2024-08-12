export class BulmaCSS {
  private readonly storageKey = "@key__bulmaCSSTheme";
  private readonly buttons = $("[data-design]");

  public recoveryDefinedColorSchema(): AppSchema {
    let defined = (document.documentElement.dataset.theme as AppSchema) ?? "";
    if (defined !== "light" && defined !== "dark") {
      defined = localStorage.getItem(this.storageKey) as AppSchema;
    }
    if (["dark", "light"].indexOf(defined) > -1) return defined as AppSchema;
    return window.matchMedia("(prefers-color-scheme: dark)").matches
      ? "dark"
      : "light";
  }

  public updateColorSchema(nextSchema?: AppSchema) {
    const schema = nextSchema ? nextSchema : this.nextColorSchema();
    this.buttons.get().forEach((button) => {
      const icon = $(button).find("i")!;

      icon.get(0)!.className =
        schema === "dark"
          ? icon.attr("data-ic-dark")!
          : icon.attr("data-ic-light")!;

      localStorage.setItem(
        this.storageKey,
        schema ? schema : this.nextColorSchema()
      );
    });
    document.documentElement.dataset.theme = schema;
  }

  public nextColorSchema(): AppSchema {
    return this.recoveryDefinedColorSchema() === "dark" ? "light" : "dark";
  }

  public listenAllThemeButton() {
    this.buttons.get().forEach((button) => {
      $(button).on("click", () =>
        this.updateColorSchema(this.nextColorSchema())
      );
    });
  }

  public animateNavMenu() {
    const navBurger = $("#navbar-burger-button");

    navBurger.on("click", () => {
      const target = $("#" + navBurger.attr("data-target"));
      const isTargetActive = target.hasClass("is-active");

      if (!isTargetActive) {
        target.slideDown();
        navBurger.addClass("is-active");
        target.addClass("is-active");
      } else
        target.slideUp({
          complete() {
            navBurger.removeClass("is-active");
            target.removeClass("is-active");
          },
        });
    });

    $(window).on("resize", () => {
      $("#" + navBurger.attr("data-target")).css({ display: "" });
    });
  }
}
