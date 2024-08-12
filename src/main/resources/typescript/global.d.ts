import {
  AnimationKassiopeiaTool,
  ScreenLockerKassiopeiaTool,
} from "kassiopeia-tools";

export {};
declare global {
  var locker: ScreenLockerKassiopeiaTool;
  var anim: AnimationKassiopeiaTool;

  type AppSchema = "dark" | "light";
}
