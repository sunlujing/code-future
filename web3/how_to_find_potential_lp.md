####  How to find potential LP address
We want to Label the Fund address in crypto world.
For ERC20 Tokens, we suppose that the LP will attend the private equity phase.
So their address should be found in the transaction for token first-phase distribution.
So we can anaylze the early phase transaction for the ERC20 token with large amount of value.

#### Find the creator address of constract 
we can use eth-scan to search the token and find the txn for the deployment.
![image](https://user-images.githubusercontent.com/54138330/203884071-ba1f6f24-3c14-4b95-a8bd-eef4fc2f18c3.png)

then, we can go to the traction details and view the address for the contract owner.
![image](https://user-images.githubusercontent.com/54138330/203884294-3509da54-4905-4597-a3ac-f9c59313ca67.png)

#### aggregate the transaction of contract owner
After get the address of the contract owner, we can browse its history transaction of the token.
Some tips for contract owner:
- the total supply of the token will be intitially sent to the owner in construction phase.
- then it will distribute the project token to their LPs based on bussiness purpose.

![image](https://user-images.githubusercontent.com/54138330/203884831-dd36a074-a224-444b-8e2d-dc7b6a493307.png)

we can view the ERC20 token transaction, by sorting the value we can find a lot of the potential LP addresses.
