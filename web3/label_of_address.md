##### Background
We want to label the address in crypto world. So we can do rich analysis of the investment behavior.
After some research, we find vendors which provide this kind of smart money analyzing.
We list some of the Links:
- https://www.nansen.ai/guides/wallet-labels-emojis-what-do-they-mean
- https://www.whatscoin.com/smart-money/nft

As mentioned by Nansen, it groups the address into multiple labels like:
- First Mover LP, Top 200 addresses based on the number of liquidity pools of a certain size that they were first movers in (First 100 addresses to enter)
- First Mover Staking	Top 200 addresses based on the number of staking pools of a certain size that they were first movers in (First 100 addresses to enter)
- Fund Public entity that invests and manages money in crypto
- and so on ....

It gives the list of labels, but tell nothing about how they label the address and link them to the investment hehavior.
We try to dive deep into each label and make it clear how it can be labeled.

##### Label of Whale
A whale is a wallet address in crypto world, which hold a significant amount of coin.
Generally, if an address hold more than 10% of the total coins of a special cryptocurrency, we can name it a whale.
Taking ethereum chain as example, we can view the top account in https://etherscan.io/accounts
![image](https://user-images.githubusercontent.com/54138330/202852313-3a77f3c3-f0ea-4e2f-93a0-2f667e636dc0.png)
It is a great work to aggregate the transaction for each address and construct this account book. 
On the other hand, it also label some address by using public announcing information, espcially for cex address, liquity pool address, etc.
The community will always watch the transaction for this top account,from which traders want to get the clue of market trend.

Beside of ethereum, traders also pay great attention to other ERC20 tokens, which account information are store in ethereum smart contract.
Every transaction event between this tokens will be logged in ethereum raw data, by aggregating the logs we can construct the account booke for ERC20 tokens.
Fortunately etherscan also provide the browsing feature of every ERC20 top Holders. 
For the tokens which published on other chain, we can label the whale address on the same way.

I think labeling the whale address is just the begining of analyzing market. At most of the time, we have no idea to guess the intension of whale's coin movement.
We need more accurate label to tell us why they do that.
