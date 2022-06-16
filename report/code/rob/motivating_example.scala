// Goal: move rob to the origin
// Also indicates if already centered 
// on some coordinate

while robOrientation !== Orientation.N do
  robRotateLeft 

if robY === Number(0) then 
  robOutput(0)
else 
  while robY !== Number(0) do
    robAdvance

robRotateRight
if robX === Number(0) then 
  robOutput(1)
else 
  while robX !== Number(0) do
    robAdvance