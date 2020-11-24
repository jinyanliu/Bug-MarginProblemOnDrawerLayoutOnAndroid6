# Bug-MarginProblemOnDrawerLayoutOnAndroid6

How to reproduce:
1. Run the code on 2 emulators, make sure one is using Android 6, one is not.
2. Open Drawer Layout by clicking the hamburger icon on left top corner.
3. Observe missing margins on Android 6. If you cannot find them, search for "// Here you can see the margin problem on Android 6:" in the whole project.

Solutions:
- Can be fixed by wrapping a LinearLayout outside of the TextViews.
